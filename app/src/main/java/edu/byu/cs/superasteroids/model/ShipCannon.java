package edu.byu.cs.superasteroids.model;

/** Ship cannon class
 *

 */
public class ShipCannon extends ShipPartAttachable {

    private int attachX;
    private int attachY;
    private int emitX;
    private int emitY;
    private String imagePath;
    private int imageWidth;
    private int imageHeight;
    private String imageAttPath;
    private int imageAttWidth;
    private int imageAttHeight;
    private String soundPath;
    private int damage;

    public ShipCannon(int attachX, int attachY, int emitX, int emitY, String imagePath, int imageWidth, int imageHeight, String imageAttPath, int imageAttWidth, int imageAttHeight, String soundPath, int damage){
        this.attachX = attachX;
        this.attachY = attachY;
        this.emitX = emitX;
        this.emitY = emitY;
        this.imagePath = imagePath;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageAttPath = imageAttPath;
        this.imageAttWidth = imageAttWidth;
        this.imageAttHeight = imageAttHeight;
        this.soundPath = soundPath;
        this.damage = damage;
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

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
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

    public String getImageAttPath() {
        return imageAttPath;
    }

    public void setImageAttPath(String imageAttPath) {
        this.imageAttPath = imageAttPath;
    }

    public int getImageAttWidth() {
        return imageAttWidth;
    }

    public void setImageAttWidth(int imageAttWidth) {
        this.imageAttWidth = imageAttWidth;
    }

    public int getImageAttHeight() {
        return imageAttHeight;
    }

    public void setImageAttHeight(int imageAttHeight) {
        this.imageAttHeight = imageAttHeight;
    }

    public int getEmitX() {
        return emitX;
    }

    public void setEmitX(int emitX) {
        this.emitX = emitX;
    }

    public int getEmitY() {
        return emitY;
    }

    public void setEmitY(int emitY) {
        this.emitY = emitY;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
