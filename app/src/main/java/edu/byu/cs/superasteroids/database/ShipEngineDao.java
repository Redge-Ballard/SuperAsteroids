package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.ShipEngine;

/** DAO to access Ship Engine Objects from the DB
 *
 */
public class ShipEngineDao {
    private SQLiteDatabase db;

    public ShipEngineDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all ShipEngine objects from the DB
     *
     * @return Array of all ShipEngine objects in the DB
     */
    public Set<ShipEngine> getAll(){
        final String SQL = "select id, speed, turnRate, attachPointX, attachPointY, imagePath" +
                "imageWidth, imageHeight" +
                "from ShipEngines";

        Set<ShipEngine> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipEngine engine = new ShipEngine();

                engine.setId(cursor.getInt(0));
                engine.setSpeed(cursor.getInt(1));
                engine.setTurnRate(cursor.getInt(2));
                engine.setAttachX(cursor.getInt(3));
                engine.setAttachY(cursor.getInt(4));
                engine.setImagePath(cursor.getString(5));
                engine.setImageWidth(cursor.getInt(6));
                engine.setImageHeight(cursor.getInt(7));

                result.add(engine);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Gets a single ShipEngine from the DB
     *
     * @param id ID for the desired ShipEngine object
     * @return Single ShipEngine object
     */
    public ShipEngine getById(Integer id){
        final String SQL = "select id, speed, turnRate, attachPointX, attachPointY, imagePath" +
                "imageWidth, imageHeight" +
                "from ShipEngines" +
                "where id = ?";

        Cursor cursor = db.rawQuery(SQL, new String[]{(id.toString())});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipEngine engine = new ShipEngine();

                engine.setId(cursor.getInt(0));
                engine.setSpeed(cursor.getInt(1));
                engine.setTurnRate(cursor.getInt(2));
                engine.setAttachX(cursor.getInt(3));
                engine.setAttachY(cursor.getInt(4));
                engine.setImagePath(cursor.getString(5));
                engine.setImageWidth(cursor.getInt(6));
                engine.setImageHeight(cursor.getInt(7));

                return engine;
            }
        }
        finally {
            cursor.close();
        }
        return null; //Should this throw some exception if not found?
    }

    /** Inserts an ShipEngine into the DB
     *
     *  @param engine ShipEngine to add
     */
    public boolean insert(ShipEngine engine){
        ContentValues values = new ContentValues();
        values.put("speed", engine.getSpeed());
        values.put("turnRate", engine.getTurnRate());
        values.put("attachPointX", engine.getAttachX());
        values.put("attachPointY", engine.getAttachY());
        values.put("imagePath", engine.getImagePath());
        values.put("imageWidth", engine.getImageWidth());
        values.put("imageHeight", engine.getImageHeight());

        long id = db.insert("ShipEngines", null, values);
        if (id >= 0) {
            engine.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }
}
