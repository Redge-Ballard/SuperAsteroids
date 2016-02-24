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
            Asteroid newObj = new Asteroid();
            newObj.setImagePath(j.getString("image"));
            newObj.setImageWidth(j.getInt("imageWidth"));
            newObj.setImageHeight(j.getInt("imageHeight"));
            newObj.setType(j.getString("type"));
            asteroids.insert(newObj);
        }
    }

    public void loadBgObjects(JSONArray json) throws JSONException {
        BgObjectDao bgObj = new BgObjectDao(db);
        for (int i = 0; i < json.length(); i++){
            BgObject newObj = new BgObject();
            newObj.setImagePath(json.getString(i));
            bgObj.insert(newObj);
        }
    }

    public void loadLevels(JSONArray json) throws JSONException {
        LevelDao bgObj = new LevelDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            LevelBgObject[] bgObjects = loadLevelObjects(j,j.getInt("number"));
            LevelAsteroid[] asteroids = loadLevelAsteroids(j,j.getInt("number"));
            Level newObj = new Level();
            newObj.setNumber(j.getInt("number"));
            newObj.setTitle(j.getString("title"));
            newObj.setHint(j.getString("hint"));
            newObj.setWidth(j.getInt("width"));
            newObj.setHeight(j.getInt("height"));
            newObj.setMusicPath(j.getString("music"));
            newObj.setLevelObjects(bgObjects);
            newObj.setLevelAsteroids(asteroids);
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
            LevelBgObject newObj = new LevelBgObject();
            newObj.setPositionX(posX);
            newObj.setPositionY(posY);
            newObj.setBgObjectId(j.getInt("objectId"));
            newObj.setScale(j.getDouble("scale"));
            newObj.setLevelId(level);
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
            LevelAsteroid newObj = new LevelAsteroid();
            newObj.setNumber(j.getInt("number"));
            newObj.setAsteroidType(j.getInt("asteroidId"));
            newObj.setLevelId(level);
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
            ShipBody newObj = new ShipBody();
            newObj.setCannonAttachX(cannonX);
            newObj.setEngineAttachY(cannonY);
            newObj.setEngineAttachX(engineX);
            newObj.setEngineAttachY(engineY);
            newObj.setExtraAttachX(extraX);
            newObj.setExtraAttachY(extraY);
            newObj.setImagePath(j.getString("image"));
            newObj.setImageWidth(j.getInt("imageWidth"));
            newObj.setImageHeight(j.getInt("imageHeight"));
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
            ShipCannon newObj = new ShipCannon();
            newObj.setAttachX(attachX);
            newObj.setAttachY(attachY);
            newObj.setEmitX(emitX);
            newObj.setEmitY(emitY);
            newObj.setImagePath(j.getString("image"));
            newObj.setImageWidth(j.getInt("imageWidth"));
            newObj.setImageHeight(j.getInt("imageHeight"));
            newObj.setImageAttPath(j.getString("attackImage"));
            newObj.setImageAttWidth(j.getInt("attackImageWidth"));
            newObj.setImageAttHeight(j.getInt("attackImageHeight"));
            newObj.setSoundPath(j.getString("attackSound"));
            newObj.setDamage(j.getInt("damge"));
            bgObj.insert(newObj);
        }
    }

    public void loadExtraParts(JSONArray json) throws JSONException {
        ShipExtraDao bgObj = new ShipExtraDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int attachX = coordinatesFromJson(j.getString("attachPoint"), "x");
            int attachY = coordinatesFromJson(j.getString("attachPoint" ), "y" );
            ShipExtra newObj = new ShipExtra();
            newObj.setAttachX(attachX);
            newObj.setAttachY(attachY);
            newObj.setImagePath(j.getString("image"));
            newObj.setImageWidth(j.getInt("imageWidth"));
            newObj.setImageHeight(j.getInt("imageHeight"));
            bgObj.insert(newObj);
        }
    }

    public void loadEngines(JSONArray json) throws JSONException {
        ShipEngineDao bgObj = new ShipEngineDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            int attachX = coordinatesFromJson(j.getString("attachPoint"), "x");
            int attachY = coordinatesFromJson(j.getString("attachPoint" ), "y" );
            ShipEngine newObj = new ShipEngine();
            newObj.setSpeed(j.getInt("baseSpeed"));
            newObj.setTurnRate(j.getInt("baseTurnRate"));
            newObj.setAttachX(attachX);
            newObj.setAttachY(attachY);
            newObj.setImagePath(j.getString("image"));
            newObj.setImageWidth(j.getInt("imageWidth"));
            newObj.setImageHeight(j.getInt("imageHeight"));
            bgObj.insert(newObj);
        }
    }

    public void loadPowerCores(JSONArray json) throws JSONException {
        ShipCoreDao bgObj = new ShipCoreDao(db);
        for (int i = 0; i < json.length(); i++){
            JSONObject j = json.getJSONObject(i);
            ShipCore newObj = new ShipCore();
            newObj.setCannonBoost(j.getInt("cannonBoost"));
            newObj.setEngineBoost(j.getInt("engineBoost"));
            newObj.setImagePath(j.getString("image"));
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
