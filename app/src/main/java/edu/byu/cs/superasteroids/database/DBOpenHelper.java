package edu.byu.cs.superasteroids.database;

import android.content.Context;
import android.database.sqlite.*;

/**
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "asteroids.sqlite";
    private static final int DB_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        final String RoidSQL =
            "create table Asteroids" +
            "(" +
            "ID integer primary key autoincrement," +
            "imagePath varchar(255) not null," +
            "imageWidth integer not null," +
            "imageHeight integer not null," +
            "type varchar(255) not null" +
            ");";
        final String bgSQL =
            "create table BgObjects" +
            "(" +
            "ID integer primary key autoincrement," +
            "imagePath varchar(255) not null" +
            ");";
        final String LevelSQL =
            "create table Levels" +
            "(" +
            "ID integer primary key autoincrement," +
            "number integer not null," +
            "title varchar(255) not null," +
            "hinteger varchar(255) not null," +
            "width integer not null," +
            "height integer not null," +
            "musicPath varchar(255) not null" +
            ");";
        final String LevelBgSQL =
            "create table LevelBgObjects" +
            "(" +
            "ID integer primary key autoincrement," +
            "positionX integer not null," +
            "positionY integer not null," +
            "BgObjectId integer not null," +
            "scale numerical(5,1) not null," +
            "levelId integer not null," +
            "foreign key (levelId) references Levels(ID)" +
            ");";
        final String LevelRoidSQL =
            "create table LevelAsteroid" +
            "(" +
            "ID integer primary key autoincrement," +
            "number integer not null," +
            "asteroidType integer not null," +
            "levelId integer not null," +
            "foreign key (levelId) references Levels(ID)" +
            ");";
        final String BodySQL =
            "create table ShipBodies" +
            "(" +
            "ID integer primary key autoincrement," +
            "cannonAttachX integer not null," +
            "cannonAttachY integer not null," +
            "engineAttachX integer not null," +
            "engineAttachY integer not null," +
            "imagePath varchar(255) not null," +
            "imageWidth integer not null," +
            "imageHeight integer not null" +
            ");";
        final String CannonSQL =
            "create table ShipCannons" +
            "(" +
            "ID integer primary key autoincrement," +
            "attachPointegerX integer not null," +
            "attachPointegerY integer not null," +
            "emitPointegerX integer not null," +
            "emitPointegerY integer not null," +
            "imagePath varchar(255) not null," +
            "imageWidth integer not null," +
            "imageHeight integer not null," +
            "imageAttPath varchar(255) not null," +
            "imageAttWidth integer not null," +
            "imageAttHeight integer not null," +
            "soundPath varchar(255) not null," +
            "damage integer not null" +
            ");";
        final String ExtraSQL =
            "create table ShipExtras" +
            "(" +
            "ID integer primary key autoincrement," +
            "attachPointegerX integer not null," +
            "attachPointegerY integer not null," +
            "imagePath varchar(255) not null," +
            "imageWidth integer not null," +
            "imageHeight integer not null" +
            ");";
        final String EngineSQL =
            "create table ShipEngines" +
            "(" +
            "ID integer primary key autoincrement," +
            "speed integer not null," +
            "turnRate integer not null," +
            "attachPointegerX integer not null," +
            "attachPointegerY integer not null," +
            "imagePath varchar(255) not null," +
            "imageWidth integer not null," +
            "imageHeight integer not null" +
            ");";
        final String CoreSQL =
            "create table ShipCores" +
            "(" +
            "ID integer primary key autoincrement," +
            "cannonBoost integer not null," +
            "engineBoost integer not null," +
            "imagePath varchar(255) not null" +
            ");";

        db.execSQL(RoidSQL);
        db.execSQL(bgSQL);
        db.execSQL(LevelSQL);
        db.execSQL(LevelBgSQL);
        db.execSQL(LevelRoidSQL);
        db.execSQL(BodySQL);
        db.execSQL(CannonSQL);
        db.execSQL(ExtraSQL);
        db.execSQL(EngineSQL);
        db.execSQL(CoreSQL);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }
}
