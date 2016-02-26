package edu.byu.cs.superasteroids.model;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

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

    public static ArrayList<Asteroid> getAsteroids() {
        ArrayList<Asteroid> list = new ArrayList<Asteroid>(asteroids);
        return list;
    }

    public static void setAsteroids(Set<Asteroid> asteroids) {
        AsteroidsGame.asteroids = asteroids;
    }

    public static ArrayList<BgObject> getBgObjects() {
        ArrayList<BgObject> list = new ArrayList<BgObject>(bgObjects);
        return list;
    }

    public static void setBgObjects(Set<BgObject> bgObjects) {
        AsteroidsGame.bgObjects = bgObjects;
    }

    public static ArrayList<LevelAsteroid> getLevelAsteroids() {
        ArrayList<LevelAsteroid> list = new ArrayList<LevelAsteroid>(levelAsteroids);
        return list;
    }

    public static void setLevelAsteroids(Set<LevelAsteroid> levelAsteroids) {
        AsteroidsGame.levelAsteroids = levelAsteroids;
    }

    public static ArrayList<LevelBackGroundObject> getLvlBgObjects() {
        ArrayList<LevelBackGroundObject> list = new ArrayList<LevelBackGroundObject>(lvlBgObjects);
        return list;
    }

    public static void setLvlBgObjects(Set<LevelBackGroundObject> lvlBgObjects) {
        AsteroidsGame.lvlBgObjects = lvlBgObjects;
    }

    public static ArrayList<Level> getLevels() {
        ArrayList<Level> list = new ArrayList<Level>(levels);
        return list;
    }

    public static void setLevels(Set<Level> levels) {
        AsteroidsGame.levels = levels;
    }

    public static ArrayList<ShipBody> getBodies() {
        ArrayList<ShipBody> list = new ArrayList<ShipBody>(bodies);
        return list;
    }

    public static void setBodies(Set<ShipBody> bodies) {
        AsteroidsGame.bodies = bodies;
    }

    public static ArrayList<ShipCannon> getCannons() {
        ArrayList<ShipCannon> list = new ArrayList<ShipCannon>(cannons);
        return list;
    }

    public static void setCannons(Set<ShipCannon> cannons) {
        AsteroidsGame.cannons = cannons;
    }

    public static ArrayList<ShipCore> getCores() {
        ArrayList<ShipCore> list = new ArrayList<ShipCore>(cores);
        return list;
    }

    public static void setCores(Set<ShipCore> cores) {
        AsteroidsGame.cores = cores;
    }

    public static ArrayList<ShipEngine> getEngines() {
        ArrayList<ShipEngine> list = new ArrayList<ShipEngine>(engines);
        return list;
    }

    public static void setEngines(Set<ShipEngine> engines) {
        AsteroidsGame.engines = engines;
    }

    public static ArrayList<ShipExtra> getExtras() {
        ArrayList<ShipExtra> list = new ArrayList<ShipExtra>(extras);
        return list;
    }

    public static void setExtras(Set<ShipExtra> extras) {
        AsteroidsGame.extras = extras;
    }
}
