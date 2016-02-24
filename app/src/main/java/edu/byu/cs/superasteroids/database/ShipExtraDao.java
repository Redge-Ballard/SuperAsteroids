package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.ShipExtra;

/** DAO to access Ship Extra Part Objects from the DB
 *
 */
public class ShipExtraDao {
    private SQLiteDatabase db;

    public ShipExtraDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all ShipExtra objects from the DB
     *
     * @return Array of all ShipExtra objects in the DB
     */
    public Set<ShipExtra> getAll(){
        final String SQL = "select id, attachPointX, attachPointY, imagePath, imageWidth, imageHeight" +
                "from ShipExtras";

        Set<ShipExtra> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipExtra extra = new ShipExtra();

                extra.setId(cursor.getInt(0));
                extra.setAttachX(cursor.getInt(1));
                extra.setAttachY(cursor.getInt(2));
                extra.setImagePath(cursor.getString(3));
                extra.setImageWidth(cursor.getInt(4));
                extra.setImageHeight(cursor.getInt(5));

                result.add(extra);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an ShipExtra into the DB
     *
     *  @param extra ShipExtra to add
     */
    public boolean insert(ShipExtra extra){
        ContentValues values = new ContentValues();
        values.put("attachPointX", extra.getAttachX());
        values.put("attachPointY", extra.getAttachY());
        values.put("imagePath", extra.getImagePath());
        values.put("imageWidth", extra.getImageWidth());
        values.put("imageHeight", extra.getImageHeight());

        long id = db.insert("ShipExtras", null, values);
        if (id >= 0) {
            extra.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all ShipExtra from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from ShipExtras";
        db.execSQL(SQL);
    }
}
