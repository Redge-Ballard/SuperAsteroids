package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.BgObject;
import edu.byu.cs.superasteroids.model.BgObject;

/**
 * Created by Azulius on 2/18/16.
 */
public class BgObjectDao {
    private SQLiteDatabase db;

    public BgObjectDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all BgObject objects from the DB
     *
     * @return Array of all BgObject objects in the DB
     */
    public Set<BgObject> getAll(){
        final String SQL = "select id, imagePath" +
                "from BgObjects";

        Set<BgObject> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                BgObject bg = new BgObject();

                bg.setId(cursor.getInt(0));
                bg.setImagePath(cursor.getString(1));

                result.add(bg);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an BgObject into the DB
     *
     *  @param bg BgObject to add
     */
    public boolean insert(BgObject bg){
        ContentValues values = new ContentValues();
        values.put("imagePath", bg.getImagePath());

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
