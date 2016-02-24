package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/18/16.
 */
public class LevelAsteroid extends DataObject {

    private int number;
    private int asteroidType;
    private int levelId;

    /** Updates the object's position and stats
     *
     */
    public void update(){
    }

    /** Draws the object on the screen
     *
     */
    public void draw(){
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
