package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.LevelBackGroundObject;

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
    public Set<LevelBackGroundObject> getAll(){
        final String SQL = "select id, positionX, positionY, BgObjectId, scale, levelId" +
                "from LevelBgObjects";

        Set<LevelBackGroundObject> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LevelBackGroundObject bg = new LevelBackGroundObject();

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

    /** Inserts a LevelBgObject into the DB
     *
     *  @param bg LevelBgObject to add
     */
    public boolean insert(LevelBackGroundObject bg){
        ContentValues values = new ContentValues();
        values.put("positionX", bg.getPositionX());
        values.put("positionY", bg.getPositionY());
        values.put("BgObjectId", bg.getBgObjectId());
        values.put("scale", bg.getScale());
        values.put("levelId", bg.getLevelId());

        long id = db.insert("LevelBgObjects", null, values);
        if (id >= 0) {
            bg.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all LevelBgObjects from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from LevelBgObjects";
        db.execSQL(SQL);
    }
}
