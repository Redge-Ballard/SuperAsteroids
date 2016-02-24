package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.ShipBody;

/** DAO to access ShipBody Objects from the DB
 *
 */
public class ShipBodyDao {
    private SQLiteDatabase db;

    public ShipBodyDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all ShipBody objects from the DB
     *
     * @return Array of all ShipBody objects in the DB
     */
    public Set<ShipBody> getAll(){
        final String SQL = "select id, cannonAttachX, cannonAttachY, engineAttachX, engineAttachY," +
                "imagePath, imageWidth, imageHeight" +
                "from ShipBodies";

        Set<ShipBody> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipBody body = new ShipBody();

                body.setId(cursor.getInt(0));
                body.setCannonAttachX(cursor.getInt(1));
                body.setCannonAttachY(cursor.getInt(2));
                body.setEngineAttachX(cursor.getInt(3));
                body.setEngineAttachY(cursor.getInt(4));
                body.setImagePath(cursor.getString(5));
                body.setImageWidth(cursor.getInt(6));
                body.setImageHeight(cursor.getInt(7));

                result.add(body);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an ShipBody into the DB
     *
     *  @param body ShipBody to add
     */
    public boolean insert(ShipBody body){
        ContentValues values = new ContentValues();
        values.put("cannonAttachX", body.getCannonAttachX());
        values.put("cannonAtachY", body.getCannonAttachY());
        values.put("engineAttachX", body.getEngineAttachX());
        values.put("engineAttachY", body.getEngineAttachY());
        values.put("imagePath", body.getImagePath());
        values.put("imageWidth", body.getImageWidth());
        values.put("imageHeight", body.getImageHeight());

        long id = db.insert("ShipBodies", null, values);
        if (id >= 0) {
            body.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all ShipBodies from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from ShipBodies";
        db.execSQL(SQL);
    }
}
