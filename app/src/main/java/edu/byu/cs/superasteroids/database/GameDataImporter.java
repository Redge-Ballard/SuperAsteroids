package edu.byu.cs.superasteroids.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.util.Scanner;

import edu.byu.cs.superasteroids.importer.IGameDataImporter;
import edu.byu.cs.superasteroids.model.Asteroid;
import edu.byu.cs.superasteroids.model.BgObject;
import edu.byu.cs.superasteroids.model.Level;
import edu.byu.cs.superasteroids.model.LevelAsteroid;
import edu.byu.cs.superasteroids.model.LevelBgObject;
import edu.byu.cs.superasteroids.model.ShipBody;
import edu.byu.cs.superasteroids.model.ShipCannon;
import edu.byu.cs.superasteroids.model.ShipCore;
import edu.byu.cs.superasteroids.model.ShipEngine;
import edu.byu.cs.superasteroids.model.ShipExtra;

/** Data Importer
 *
 */
public class GameDataImporter implements IGameDataImporter{

    private DBOpenHelper dbHelper;
    private SQLiteDatabase db;

    public GameDataImporter(Context context) {
        dbHelper = new DBOpenHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public boolean importData(InputStreamReader dataInputReader) {
        Scanner scan = new Scanner(dataInputReader);
        StringBuilder input = new StringBuilder();
        while (scan.hasNext()){
            input.append(scan.next());
        }
        scan.close();
        try {
            JSONObject json = new JSONObject(input.toString());
            loadJsonData(json);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void loadJsonData(JSONObject json) throws JSONException {
        JSONArray bgObjects = json.getJSONArray("objects");
        loadBgObjects(bgObjects);
        JSONArray asteroids = json.getJSONArray("asteroids");
        loadAsteroids(asteroids);
        JSONArray levels = json.getJSONArray("levels");
        loadLevels(levels);
        JSONArray mainBodies = json.getJSONArray("mainBodies");
        loadMainBodies(mainBodies);
        JSONArray cannons = json.getJSONArray("cannons");
        loadCannons(cannons);
        JSONArray extraParts = json.getJSONArray("extraParts");
        loadExtraParts(extraParts);
        JSONArray engines = json.getJSONArray("engines");
        loadEngines(engines);
        JSONArray powerCores = json.getJSONArray("powerCores");
        loadPowerCores(powerCores);
    }

    public void loadAsteroids(JSONArray json) throws JSONException {
        AsteroidDao asteroids = new AsteroidDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            Asteroid newObj = new Asteroid(j.getString("image"), j.getInt("imageWidth"), j.getInt("imageHeight"), j.getString("type"));
            asteroids.insert(newObj);
        }
    }

    public void loadBgObjects(JSONArray json) throws JSONException {
        BgObjectDao bgObj = new BgObjectDao(db);
        for (int i = 0; i < json.length(); i++){
            BgObject newObj = new BgObject(json.getString(i));
            bgObj.insert(newObj);
        }
    }

    public void loadLevels(JSONArray json) throws JSONException {
        LevelDao bgObj = new LevelDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            LevelBgObject[] bgObjects = loadLevelObjects(j,j.getInt("number"));
            LevelAsteroid[] asteroids = loadLevelAsteroids(j,j.getInt("number"));
            Level newObj = new Level(j.getInt("number" ),j.getString("title"),j.getString("hint"),j.getInt("width"),j.getInt("height"),j.getString("music"), bgObjects, asteroids); //get other arrays
            bgObj.insert(newObj);
        }
    }

    public LevelBgObject[] loadLevelObjects(JSONObject object, int level) throws JSONException {
        LevelBgObjectDao bgObjects = new LevelBgObjectDao(db);
        JSONArray json = object.getJSONArray("levelObjects");
        LevelBgObject[] bgArray = new LevelBgObject[json.length()];
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int posX = coordinatesFromJson(j.getString("position" ), "x" );
            int posY = coordinatesFromJson(j.getString("position" ), "y" );
            LevelBgObject newObj = new LevelBgObject(posX, posY, j.getInt("objectId"), j.getDouble("scale" ), level);
            bgObjects.insert(newObj);
            bgArray[i] = newObj;
        }
        return bgArray;
    }

    public LevelAsteroid[] loadLevelAsteroids(JSONObject object, int level) throws JSONException {
        LevelAsteroidDao asteroids = new LevelAsteroidDao(db);
        JSONArray json = object.getJSONArray("levelAsteroids");
        LevelAsteroid[] asteroidArray = new LevelAsteroid[json.length()];
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            LevelAsteroid newObj = new LevelAsteroid(j.getInt("number"), j.getInt("asteroidId" ), level);
            asteroids.insert(newObj);
            asteroidArray[i] = newObj;
        }
        return asteroidArray;
    }

    public void loadMainBodies(JSONArray json) throws JSONException {
        ShipBodyDao bgObj = new ShipBodyDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int cannonX = coordinatesFromJson(j.getString("cannonAttach"), "x");
            int cannonY = coordinatesFromJson(j.getString("cannonAttach"), "y");
            int engineX = coordinatesFromJson(j.getString("engineAttach"),"x");
            int engineY = coordinatesFromJson(j.getString("engineAttach"),"y");
            int extraX = coordinatesFromJson(j.getString("extraAttach"),"x");
            int extraY = coordinatesFromJson(j.getString("extraAttach"),"y");
            ShipBody newObj = new ShipBody(cannonX, cannonY, engineX, engineY, extraX, extraY, j.getString("image"),j.getInt("imageWidth"),j.getInt("imageHeight"));
            bgObj.insert(newObj);
        }
    }

    public void loadCannons(JSONArray json) throws JSONException {
        ShipCannonDao bgObj = new ShipCannonDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int attachX = coordinatesFromJson(j.getString("attachPoint"), "x");
            int attachY = coordinatesFromJson(j.getString("attachPoint" ), "y" );
            int emitX = coordinatesFromJson(j.getString("emitPoint"), "x");
            int emitY = coordinatesFromJson(j.getString("emitPoint"),"y");
            ShipCannon newObj = new ShipCannon(attachX, attachY, emitX, emitY, j.getString("image"),j.getInt("imageWidth"),j.getInt("imageHeight"),j.getString("attackImage"),j.getInt("attackImageWidth"),j.getInt("attackImageHeight"),j.getString("attackSound"),j.getInt("damage"));
            bgObj.insert(newObj);
        }
    }

    public void loadExtraParts(JSONArray json) throws JSONException {
        ShipExtraDao bgObj = new ShipExtraDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int attachX = coordinatesFromJson(j.getString("attachPoint"), "x");
            int attachY = coordinatesFromJson(j.getString("attachPoint" ), "y" );
            ShipExtra newObj = new ShipExtra(attachX, attachY, j.getString("image"),j.getInt("imageWidth"),j.getInt("imageHeight"));
            bgObj.insert(newObj);
        }
    }

    public void loadEngines(JSONArray json) throws JSONException {
        ShipEngineDao bgObj = new ShipEngineDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int attachX = coordinatesFromJson(j.getString("attachPoint"), "x");
            int attachY = coordinatesFromJson(j.getString("attachPoint" ), "y" );
            ShipEngine newObj = new ShipEngine(j.getInt("baseSpeed"),j.getInt("baseTurnRate"), attachX, attachY,j.getString("image"),j.getInt("imageWidth"),j.getInt("imageHeight"));
            bgObj.insert(newObj);
        }
    }

    public void loadPowerCores(JSONArray json) throws JSONException {
        ShipCoreDao bgObj = new ShipCoreDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            ShipCore newObj = new ShipCore(j.getInt("cannonBoost"),j.getInt("engineBoost"),j.getString("image"));
            bgObj.insert(newObj);
        }
    }

    public int coordinatesFromJson(String toSplit, String coord){
        String coords[];
        coords = (toSplit.split(","));
        if (coord == "x"){
            return Integer.parseInt(coords[0]);
        }
        else if (coord == "y"){
            return Integer.parseInt(coords[1]);
        }
        else {
            return -1;
        }
    }

}
