package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/18/16.
 */
public class LevelAsteroid extends SuperObject {

    private int number;
    private int asteroidType;
    private int levelId;

    public LevelAsteroid(int number, int asteroidType, int level){
        this.number = number;
        this.asteroidType = asteroidType;
        this.levelId = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAsteroidType() {
        return asteroidType;
    }

    public void setAsteroidType(int asteroidType) {
        this.asteroidType = asteroidType;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
