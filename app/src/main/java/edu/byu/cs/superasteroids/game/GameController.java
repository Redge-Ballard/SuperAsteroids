package edu.byu.cs.superasteroids.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import edu.byu.cs.superasteroids.base.IGameDelegate;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.database.LevelBgObjectDao;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.Asteroid;
import edu.byu.cs.superasteroids.model.AsteroidsGame;
import edu.byu.cs.superasteroids.model.Level;
import edu.byu.cs.superasteroids.model.LevelAsteroid;
import edu.byu.cs.superasteroids.model.LevelBackGroundObject;
import edu.byu.cs.superasteroids.model.Ship;

/**
 * Created by Azulius on 2/27/16.
 */
public class GameController implements IGameDelegate {

    private Map<String, Integer> partsId = new HashMap<String, Integer>();
    private Level currentLevel = new Level();
    private ArrayList<LevelAsteroid> currentRoids = new ArrayList<>();
    private ArrayList<LevelBackGroundObject> currentBgObjects = new ArrayList<>();
    private ArrayList<Integer> roidIds = new ArrayList<>();
    private ArrayList<Integer> bgIds = new ArrayList<>();
    private int levelNumber;

    @Override
    public void update(double elapsedTime) {

    }

    @Override
    public void loadContent(ContentManager content) {
        setUpLevel();
        partsId.put("body", content.loadImage(Ship.getBody().getImagePath()));
        partsId.put("cannon",content.loadImage(Ship.getCannon().getImagePath()));
        partsId.put("engine", content.loadImage(Ship.getEngine().getImagePath()));
        partsId.put("extra", content.loadImage(Ship.getExtra().getImagePath()));
        for (int i = 0; i < currentRoids.size(); i++){
            roidIds.add(content.loadImage(currentRoids.get(i).getImagePath()));
        }
        for (int i = 0; i < currentBgObjects.size(); i++){
            bgIds.add(content.loadImage(currentBgObjects.get(i).getImagePath()));
        }
        try {
            content.loadLoopSound(currentLevel.getMusicPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unloadContent(ContentManager content) {

    }

    @Override
    public void draw() {
        int centerX = DrawingHelper.getGameViewWidth()/2;
        int centerY = DrawingHelper.getGameViewHeight()/2;
        float scale = 0.25f;
        DrawingHelper.drawImage(partsId.get("body"), centerX, centerY, 0, scale, scale, 255);
        int xPoint = (Ship.getBody().getCannonAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getCannon().getImageWidth()/2-Ship.getCannon().getAttachX());
        int xScaled = (int)(xPoint * scale);
        int yPoint = (Ship.getBody().getCannonAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getCannon().getImageHeight()/2-Ship.getCannon().getAttachY());
        int yScaled = (int)(yPoint * scale);
        DrawingHelper.drawImage(partsId.get("cannon"), centerX + xScaled, centerY + yScaled, 0, scale, scale, 255);
        xPoint = (Ship.getBody().getEngineAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getEngine().getImageWidth()/2-Ship.getEngine().getAttachX());
        xScaled = (int)(xPoint * scale);
        yPoint = (Ship.getBody().getEngineAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getEngine().getImageHeight()/2-Ship.getEngine().getAttachY());
        yScaled = (int)(yPoint * scale);
        DrawingHelper.drawImage(partsId.get("engine"), centerX + xScaled, centerY + yScaled, 0, scale, scale, 255);
        xPoint = (Ship.getBody().getExtraAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getExtra().getImageWidth()/2-Ship.getExtra().getAttachX());
        xScaled = (int)(xPoint * scale);
        yPoint = (Ship.getBody().getExtraAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getExtra().getImageHeight()/2-Ship.getExtra().getAttachY());
        yScaled = (int)(yPoint * scale);
        DrawingHelper.drawImage(partsId.get("extra"), centerX + xScaled, centerY + yScaled, 0, scale, scale, 255);
    }

    public void setUpLevel(){
        ArrayList<Level> levels = AsteroidsGame.getLevels();
        currentLevel = levels.get(levelNumber);
        currentRoids = currentLevel.getLevelAsteroids();
        currentBgObjects = currentLevel.getLevelObjects();
    }

    public void setLevelNumber(int level){
        levelNumber = level;
    }
}
