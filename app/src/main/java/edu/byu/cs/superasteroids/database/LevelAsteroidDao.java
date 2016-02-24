package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.LevelAsteroid;

/**
 * Created by Azulius on 2/18/16.
 */
public class LevelAsteroidDao {

    private SQLiteDatabase db;

    public LevelAsteroidDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all LevelAsteroid objects from the DB
     *
     * @return Array of all BG objects in the DB
     */
    public Set<LevelAsteroid> getAll(){
        final String SQL = "select id, number, asteroidType, levelId" +
                "from LevelAsteroids";

        Set<LevelAsteroid> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LevelAsteroid roid = new LevelAsteroid();

                roid.setId(cursor.getInt(0));
                roid.setNumber(cursor.getInt(1));
                roid.setAsteroidType(cursor.getInt(2));
                roid.setLevelId(cursor.getInt(3));

                result.add(roid);

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
    public LevelAsteroid getById(Integer id){
        final String SQL = "select id, number, asteroidType, levelId" +
                "from LevelAsteroids" +
                "where id = ?";

        Cursor cursor = db.rawQuery(SQL, new String[]{(id.toString())});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LevelAsteroid roid = new LevelAsteroid();

                roid.setId(cursor.getInt(0));
                roid.setNumber(cursor.getInt(1));
                roid.setAsteroidType(cursor.getInt(2));
                roid.setLevelId(cursor.getInt(3));

                return roid;
            }
        }
        finally {
            cursor.close();
        }
        return null; //Should this throw some exception if not found?
    }

    /** Inserts an BgObject into the DB
     *
     *  @param roid BgObject to add
     */
    public boolean insert(LevelAsteroid roid){
        ContentValues values = new ContentValues();
        values.put("number", roid.getNumber());
        values.put("asteroidType", roid.getAsteroidType());
        values.put("levelId", roid.getLevelId());

        long id = db.insert("BgObjects", null, values);
        if (id >= 0) {
            roid.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }
}
