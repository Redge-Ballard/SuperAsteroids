package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/18/16.
 */
public class Level extends SuperObject{

    private int number;
    private String title;
    private String hint;
    private int width;
    private int height;
    private String musicPath;
    private LevelBgObject[] levelObjects;
    private LevelAsteroid[] levelAsteroids;

    public Level(int number, String title, String hint, int width, int height, String musicPath, LevelBgObject[] objects, LevelAsteroid[] asteroids){
        this.number = number;
        this.title = title;
        this.hint = hint;
        this.width = width;
        this.height = height;
        this.musicPath = musicPath;
        this.levelObjects = objects;
        this.levelAsteroids = asteroids;
    }

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
}
