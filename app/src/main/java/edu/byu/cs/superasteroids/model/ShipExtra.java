package edu.byu.cs.superasteroids.model;

/** Ship extra part class
 *

 */
public class ShipExtra {

    private int attachX;
    private int attachY;
    private String imagePath;
    private int imageWidth;
    private int imageHeight;

    public ShipExtra(int attachX, int attachY, String imagePath, int imageWidth, int imageHeight){
        this.attachX = attachX;
        this.attachY = attachY;
        this.imagePath = imagePath;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
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

    public int getAttachX() {
        return attachX;
    }

    public void setAttachX(int attachX) {
        this.attachX = attachX;
    }

    public int getAttachY() {
        return attachY;
    }

    public void setAttachY(int attachY) {
        this.attachY = attachY;
    }
}
