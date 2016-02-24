package edu.byu.cs.superasteroids.model;

/** Ship main body class
 *

 */
public class ShipBody {

    private int cannonAttachX;
    private int cannonAttachY;
    private int engineAttachX;
    private int engineAttachY;
    private int extraAttachX;
    private int extraAttachY;
    private String imagePath;
    private int imageWidth;
    private int imageHeight;

    public ShipBody(int cannonX, int cannonY, int engineX, int engineY, int extraX, int extraY, String path, int width, int height){

        this.cannonAttachX = cannonX;
        this.cannonAttachY = cannonY;
        this.engineAttachX = engineX;
        this.engineAttachY = engineY;
        this.extraAttachX = extraX;
        this.engineAttachY = extraY;
        this.imagePath = path;
        this.imageWidth = width;
        this.imageHeight = height;
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getCannonAttachX() {
        return cannonAttachX;
    }

    public void setCannonAttachX(int cannonAttachX) {
        this.cannonAttachX = cannonAttachX;
    }

    public int getCannonAttachY() {
        return cannonAttachY;
    }

    public void setCannonAttachY(int cannonAttachY) {
        this.cannonAttachY = cannonAttachY;
    }

    public int getEngineAttachX() {
        return engineAttachX;
    }

    public void setEngineAttachX(int engineAttachX) {
        this.engineAttachX = engineAttachX;
    }

    public int getEngineAttachY() {
        return engineAttachY;
    }

    public void setEngineAttachY(int engineAttachY) {
        this.engineAttachY = engineAttachY;
    }
}
