package edu.byu.cs.superasteroids.model;

import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import edu.byu.cs.superasteroids.database.AsteroidDao;
import edu.byu.cs.superasteroids.database.BgObjectDao;
import edu.byu.cs.superasteroids.database.DBOpenHelper;
import edu.byu.cs.superasteroids.database.LevelAsteroidDao;
import edu.byu.cs.superasteroids.database.LevelBgObjectDao;
import edu.byu.cs.superasteroids.database.LevelDao;
import edu.byu.cs.superasteroids.database.ShipBodyDao;
import edu.byu.cs.superasteroids.database.ShipCannonDao;
import edu.byu.cs.superasteroids.database.ShipCoreDao;
import edu.byu.cs.superasteroids.database.ShipEngineDao;
import edu.byu.cs.superasteroids.database.ShipExtraDao;

/**
 * Created by Azulius on 2/24/16.
 */
public class AsteroidsGame {

    private static DBOpenHelper dataHelper;
    private static SQLiteDatabase database;
    private static Set<Asteroid> asteroids = new HashSet<Asteroid>();
    private static Set<BgObject> bgObjects = new HashSet<BgObject>();
    private static Set<LevelAsteroid>  levelAsteroids = new HashSet<LevelAsteroid>();
    private static Set<LevelBackGroundObject> lvlBgObjects = new HashSet<LevelBackGroundObject>();
    private static Set<Level> levels = new HashSet<Level>();
    private static Set<ShipBody> bodies = new HashSet<ShipBody>();
    private static Set<ShipCannon> cannons = new HashSet<ShipCannon>();
    private static Set<ShipCore> cores = new HashSet<ShipCore>();
    private static Set<ShipEngine> engines = new HashSet<ShipEngine>();
    private static Set<ShipExtra> extras = new HashSet<ShipExtra>();

    public static void init(Context context){
        dataHelper = new DBOpenHelper(context);
        database = dataHelper.getWritableDatabase();
    }

    public static void loadModels() {
        if (database != null) {
            AsteroidDao roidDao = new AsteroidDao(database);
            asteroids = roidDao.getAll();
            BgObjectDao bgDao = new BgObjectDao(database);
            bgObjects = bgDao.getAll();
            LevelAsteroidDao levelRoidDao = new LevelAsteroidDao(database);
            levelAsteroids = levelRoidDao.getAll();
            LevelBgObjectDao levelBgDao = new LevelBgObjectDao(database);
            lvlBgObjects = levelBgDao.getAll();
            LevelDao levelDao = new LevelDao(database);
            levels = levelDao.getAll();
            ShipBodyDao bodyDao = new ShipBodyDao(database);
            bodies = bodyDao.getAll();
            ShipCannonDao cannonDao = new ShipCannonDao(database);
            cannons = cannonDao.getAll();
            ShipCoreDao coreDao = new ShipCoreDao(database);
            cores = coreDao.getAll();
            ShipEngineDao engineDao = new ShipEngineDao(database);
            engines = engineDao.getAll();
            ShipExtraDao extraDao = new ShipExtraDao(database);
            extras = extraDao.getAll();
        }
    }

    public static DBOpenHelper getDataHelper() {
        return dataHelper;
    }

    public static void setDataHelper(DBOpenHelper dataHelper) {
        AsteroidsGame.dataHelper = dataHelper;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }

    public static void setDatabase(SQLiteDatabase database) {
        AsteroidsGame.database = database;
    }

    public static Set<Asteroid> getAsteroids() {
        return asteroids;
    }

    public static void setAsteroids(Set<Asteroid> asteroids) {
        AsteroidsGame.asteroids = asteroids;
    }

    public static Set<BgObject> getBgObjects() {
        return bgObjects;
    }

    public static void setBgObjects(Set<BgObject> bgObjects) {
        AsteroidsGame.bgObjects = bgObjects;
    }

    public static Set<LevelAsteroid> getLevelAsteroids() {
        return levelAsteroids;
    }

    public static void setLevelAsteroids(Set<LevelAsteroid> levelAsteroids) {
        AsteroidsGame.levelAsteroids = levelAsteroids;
    }

    public static Set<LevelBackGroundObject> getLvlBgObjects() {
        return lvlBgObjects;
    }

    public static void setLvlBgObjects(Set<LevelBackGroundObject> lvlBgObjects) {
        AsteroidsGame.lvlBgObjects = lvlBgObjects;
    }

    public static Set<Level> getLevels() {
        return levels;
    }

    public static void setLevels(Set<Level> levels) {
        AsteroidsGame.levels = levels;
    }

    public static Set<ShipBody> getBodies() {
        return bodies;
    }

    public static void setBodies(Set<ShipBody> bodies) {
        AsteroidsGame.bodies = bodies;
    }

    public static Set<ShipCannon> getCannons() {
        return cannons;
    }

    public static void setCannons(Set<ShipCannon> cannons) {
        AsteroidsGame.cannons = cannons;
    }

    public static Set<ShipCore> getCores() {
        return cores;
    }

    public static void setCores(Set<ShipCore> cores) {
        AsteroidsGame.cores = cores;
    }

    public static Set<ShipEngine> getEngines() {
        return engines;
    }

    public static void setEngines(Set<ShipEngine> engines) {
        AsteroidsGame.engines = engines;
    }

    public static Set<ShipExtra> getExtras() {
        return extras;
    }

    public static void setExtras(Set<ShipExtra> extras) {
        AsteroidsGame.extras = extras;
    }
}
