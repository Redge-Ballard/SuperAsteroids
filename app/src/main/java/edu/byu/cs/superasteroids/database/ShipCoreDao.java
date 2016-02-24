package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.ShipCore;

/** DAO to access Ship Core Objects from the DB
 *
 */
public class ShipCoreDao {
    private SQLiteDatabase db;

    public ShipCoreDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all ShipCore objects from the DB
     *
     * @return Array of all ShipCore objects in the DB
     */
    public Set<ShipCore> getAll(){
        final String SQL = "select id, cannonBoost, engineBoost, imagePath" +
                "from ShipCores";

        Set<ShipCore> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipCore core = new ShipCore();

                core.setId(cursor.getInt(0));
                core.setCannonBoost(cursor.getInt(1));
                core.setEngineBoost(cursor.getInt(2));
                core.setImagePath(cursor.getString(3));

                result.add(core);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Gets a single ShipCore from the DB
     *
     * @param id ID for the desired ShipCore object
     * @return Single ShipCore object
     */
    public ShipCore getById(Integer id){
        final String SQL = "select id, cannonBoost, engineBoost, imagePath" +
                "from ShipCores" +
                "where id = ?";

        Cursor cursor = db.rawQuery(SQL, new String[]{(id.toString())});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipCore core = new ShipCore();

                core.setId(cursor.getInt(0));
                core.setCannonBoost(cursor.getInt(1));
                core.setEngineBoost(cursor.getInt(2));
                core.setImagePath(cursor.getString(3));

                return core;
            }
        }
        finally {
            cursor.close();
        }
        return null; //Should this throw some exception if not found?
    }

    /** Inserts an ShipCore into the DB
     *
     *  @param core ShipCore to add
     */
    public boolean insert(ShipCore core){
        ContentValues values = new ContentValues();
        values.put("cannonBoost", core.getCannonBoost());
        values.put("engineBoost", core.getEngineBoost());
        values.put("imagePath", core.getImagePath());

        long id = db.insert("ShipCores", null, values);
        if (id >= 0) {
            core.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }
}
