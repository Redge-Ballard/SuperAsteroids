package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.Asteroid;

/** DAO to access Asteroid objects from the DB
 *
 */

public class AsteroidDao {

    private SQLiteDatabase db;

    public AsteroidDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all asteroid objects from the DB
     *
     * @return Array of all Asteroid objects in the DB
     */
    public Set<Asteroid> getAll(){
        final String SQL = "select id, imagePath, imageWidth, imageHeight, type " +
                "from Asteroids";

        Set<Asteroid> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Asteroid asteroid = new Asteroid();

                asteroid.setId(cursor.getInt(0));
                asteroid.setImagePath(cursor.getString(1));
                asteroid.setImageWidth(cursor.getInt(2));
                asteroid.setImageHeight(cursor.getInt(3));
                asteroid.setType(cursor.getString(4));

                result.add(asteroid);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an asteroid into the DB
     *
     *  @param roid Asteroid to add
     */
    public boolean insert(Asteroid roid){
        ContentValues values = new ContentValues();
        values.put("imagePath", roid.getImagePath());
        values.put("imageWidth", roid.getImageWidth());
        values.put("imageHeight", roid.getImageHeight());
        values.put("type", roid.getType());

        long id = db.insert("Asteroids", null, values);
        if (id >= 0) {
            roid.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all asteroids from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from Asteroids";
        db.execSQL(SQL);
    }
}
