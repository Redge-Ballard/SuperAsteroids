package edu.byu.cs.superasteroids.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Azulius on 2/18/16.
 */
public class Level extends DataObject {

    private int number;
    private String title;
    private String hint;
    private int width;
    private int height;
    private String musicPath;
    private ArrayList<LevelBackGroundObject> levelObjects = new ArrayList<>();
    private ArrayList<LevelAsteroid> levelAsteroids = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public ArrayList<LevelBackGroundObject> getLevelObjects() {
        return levelObjects;
    }

    public void setLevelObjects(ArrayList<LevelBackGroundObject> levelObjects) {
        this.levelObjects = levelObjects;
    }

    public ArrayList<LevelAsteroid> getLevelAsteroids() {
        return levelAsteroids;
    }

    public void setLevelAsteroids(ArrayList<LevelAsteroid> levelAsteroids) {
        this.levelAsteroids = levelAsteroids;
    }
}
