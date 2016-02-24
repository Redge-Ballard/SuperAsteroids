package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.LevelBgObject;

/** DAO to access BG Objects from the DB
 *
 */
public class LevelBgObjectDao {

    private SQLiteDatabase db;

    public LevelBgObjectDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all LevelBgObject objects from the DB
     *
     * @return Array of all BG objects in the DB
     */
    public Set<LevelBgObject> getAll(){
        final String SQL = "select id, positionX, positionY, BgObjectId, scale, levelId" +
                "from LevelBgObjects";

        Set<LevelBgObject> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LevelBgObject bg = new LevelBgObject();

                bg.setId(cursor.getInt(0));
                bg.setPositionX(cursor.getInt(1));
                bg.setPositionY(cursor.getInt(2));
                bg.setBgObjectId(cursor.getInt(3));
                bg.setScale(cursor.getDouble(4));
                bg.setLevelId(cursor.getInt(5));

                result.add(bg);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Gets a single BgObject from the DB
     *
     * @param id ID for the desired BgObject object
     * @return Single BgObject object
     */
    public LevelBgObject getById(Integer id){
        final String SQL = "select id, positionX, positionY, BgObjectId, scale, levelId" +
                "from LevelBgObjects" +
                "where id = ?";

        Cursor cursor = db.rawQuery(SQL, new String[]{(id.toString())});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LevelBgObject bg = new LevelBgObject();

                bg.setId(cursor.getInt(0));
                bg.setPositionX(cursor.getInt(1));
                bg.setPositionY(cursor.getInt(2));
                bg.setBgObjectId(cursor.getInt(3));
                bg.setScale(cursor.getDouble(4));
                bg.setLevelId(cursor.getInt(5));

                return bg;
            }
        }
        finally {
            cursor.close();
        }
        return null; //Should this throw some exception if not found?
    }

    /** Inserts an BgObject into the DB
     *
     *  @param bg BgObject to add
     */
    public boolean insert(LevelBgObject bg){
        ContentValues values = new ContentValues();
        values.put("positionX", bg.getPositionX());
        values.put("positionY", bg.getPositionY());
        values.put("BgObjectId", bg.getBgObjectId());
        values.put("scale", bg.getScale());
        values.put("levelId", bg.getLevelId());

        long id = db.insert("BgObjects", null, values);
        if (id >= 0) {
            bg.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }
}
