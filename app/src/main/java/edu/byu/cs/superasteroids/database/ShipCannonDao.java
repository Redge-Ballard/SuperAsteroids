package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.ShipCannon;

/** DAO to access Ship Cannon Objects from the DB
 *
 */
public class ShipCannonDao {
    private SQLiteDatabase db;

    public ShipCannonDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all ShipCannon objects from the DB
     *
     * @return Array of all ShipCannon objects in the DB
     */
    public Set<ShipCannon> getAll(){
        final String SQL = "select id, attachPointX, attachPointY, emitPointX, emitPointY, imagePath" +
                "imageWidth, imageHeight, imageAttPath, imageAttWidth, imageAttHeight, soundPath, damage" +
                "from ShipCannons";

        Set<ShipCannon> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ShipCannon cannon = new ShipCannon();

                cannon.setId(cursor.getInt(0));
                cannon.setAttachX(cursor.getInt(1));
                cannon.setAttachY(cursor.getInt(2));
                cannon.setEmitX(cursor.getInt(3));
                cannon.setEmitY(cursor.getInt(4));
                cannon.setImagePath(cursor.getString(5));
                cannon.setImageWidth(cursor.getInt(6));
                cannon.setImageHeight(cursor.getInt(7));
                cannon.setImageAttPath(cursor.getString(8));
                cannon.setImageAttWidth(cursor.getInt(9));
                cannon.setImageAttHeight(cursor.getInt(10));
                cannon.setSoundPath(cursor.getString(11));
                cannon.setDamage(cursor.getInt(12));

                result.add(cannon);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an ShipCannon into the DB
     *
     *  @param cannon ShipCannon to add
     */
    public boolean insert(ShipCannon cannon){
        ContentValues values = new ContentValues();
        values.put("attachPointX", cannon.getAttachX());
        values.put("attachPointY", cannon.getAttachY());
        values.put("emitPointX", cannon.getEmitX());
        values.put("emitPointY", cannon.getEmitY());
        values.put("imagePath", cannon.getImagePath());
        values.put("imageWidth", cannon.getImageWidth());
        values.put("imageHeight", cannon.getImageHeight());
        values.put("imageAttPath", cannon.getImageAttPath());
        values.put("imageAttWidth", cannon.getImageAttWidth());
        values.put("imageAttHeight", cannon.getImageAttHeight());
        values.put("soundPath", cannon.getSoundPath());
        values.put("damage", cannon.getDamage());

        long id = db.insert("ShipCannons", null, values);
        if (id >= 0) {
            cannon.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all ShipCannons from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from ShipCannons";
        db.execSQL(SQL);
    }
}
