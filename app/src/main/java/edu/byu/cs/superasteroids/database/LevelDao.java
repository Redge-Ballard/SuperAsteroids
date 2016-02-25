package edu.byu.cs.superasteroids.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.model.Level;

/**
 * Created by Azulius on 2/18/16.
 */
public class LevelDao {
    private SQLiteDatabase db;

    public LevelDao(SQLiteDatabase db) {
        this.db = db;
    }

    /** Gets all Level objects from the DB
     *
     * @return Array of all Level objects in the DB
     */
    public Set<Level> getAll(){
        final String SQL = "select id, title, hint, width, height, musicPath" +
                "from Levels";

        Set<Level> result = new HashSet<>();

        Cursor cursor = db.rawQuery(SQL, new String[]{});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Level level = new Level();

                level.setId(cursor.getInt(0));
                level.setTitle(cursor.getString(1));
                level.setHint(cursor.getString(2));
                level.setWidth(cursor.getInt(3));
                level.setHeight(cursor.getInt(4));
                level.setMusicPath(cursor.getString(5));

                result.add(level);

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return result;
    }

    /** Inserts an Level into the DB
     *
     *  @param level Level to add
     */
    public boolean insert(Level level){
        ContentValues values = new ContentValues();
        values.put("number", level.getNumber());
        values.put("title", level.getTitle());
        values.put("hint", level.getHint());
        values.put("width", level.getWidth());
        values.put("height", level.getHeight());
        values.put("musicPath", level.getMusicPath());

        long id = db.insert("Levels", null, values);
        if (id >= 0) {
            level.setId(((int) id));
            return true;
        }
        else {
            return false;
        }
    }

    /** Clears all Levels from the DB
     *
     */
    public void clearAll(){
        final String SQL = "delete from Levels";
        db.execSQL(SQL);
    }
}
