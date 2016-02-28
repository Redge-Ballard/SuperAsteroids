package edu.byu.cs.superasteroids.model;

/** LevelBgObject object class
 *

 */
public class LevelBackGroundObject extends DataObject {

    private int positionX;
    private int positionY;
    /** Represents which BG object in array */
    private int BgObjectId;
    private double scale;
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getBgObjectId() {
        return BgObjectId;
    }

    public void setBgObjectId(int bgObjectId) {
        BgObjectId = bgObjectId;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getImagePath() {
        return AsteroidsGame.getLvlBgObjects().get(BgObjectId).getImagePath();
    }
}
