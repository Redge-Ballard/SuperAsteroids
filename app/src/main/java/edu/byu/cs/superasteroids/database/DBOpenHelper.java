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
            "ID int auto_increment not null," +
            "imagePath varchar(255) not null," +
            "imageWidth int not null," +
            "imageHeight int not null," +
            "type varchar(255) not null" +
            ");";
        final String bgSQL =
            "create table BgObjects" +
            "(" +
            "ID int auto_increment not null," +
            "path varchar(255)" +
            ");";
        final String LevelSQL =
            "create table Levels" +
            "(" +
            "ID int auto_increment not null," +
            "number int not null," +
            "title varchar(255) not null," +
            "hint varchar(255) not null," +
            "width int not null," +
            "height int not null," +
            "musicPath varchar(255) not null" +
            ");";
        final String LevelBgSQL =
            "create table LevelBgObjects" +
            "(" +
            "ID int auto_increment not null," +
            "positionX int not null," +
            "positionY int not null," +
            "BgObjectId int not null," +
            "scale numerical(5,1) not null," +
            "levelId int not null," +
            "foreign key (levelId) references Levels(ID)" +
            ");";
        final String LevelRoidSQL =
            "create table LevelAsteroid" +
            "(" +
            "ID int auto_increment not null," +
            "number int not null," +
            "asteroidType int not null," +
            "levelId int not null," +
            "foreign key (levelId) references Levels(ID)" +
            ");";
        final String BodySQL =
            "create table ShipBodies" +
            "(" +
            "ID int auto_increment not null," +
            "cannonAttachX int not null," +
            "cannonAttachY int not null," +
            "engineAttachX int not null," +
            "engineAttachY int not null," +
            "imagePath varchar(255) not null," +
            "imageWidth int not null," +
            "imageHeight int not null" +
            ");";
        final String CannonSQL =
            "create table ShipCannons" +
            "(" +
            "ID int auto_increment not null," +
            "attachPointX int not null," +
            "attachPointY int not null," +
            "emitPointX int not null," +
            "emitPointY int not null," +
            "imagePath varchar(255) not null," +
            "imageWidth int not null," +
            "imageHeight int not null," +
            "imageAttPath varchar(255) not null," +
            "imageAttWidth int not null," +
            "imageAttHeight int not null," +
            "soundPath varchar(255) not null," +
            "damage int not null" +
            ");";
        final String ExtraSQL =
            "create table ShipExtras" +
            "(" +
            "ID int auto_increment not null," +
            "attachPointX int not null," +
            "attachPointY int not null," +
            "imagePath varchar(255) not null," +
            "imageWidth int not null," +
            "imageHeight int not null" +
            ");";
        final String EngineSQL =
            "create table ShipEngines" +
            "(" +
            "ID int auto_increment not null," +
            "speed int not null," +
            "turnRate int not null," +
            "attachPointX int not null," +
            "attachPointY int not null," +
            "imagePath varchar(255) not null," +
            "imageWidth int not null," +
            "imageHeight int not null" +
            ");";
        final String CoreSQL =
            "create table ShipCores" +
            "(" +
            "ID int auto_increment not null," +
            "cannonBoost int not null," +
            "engineBoost int not null," +
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
