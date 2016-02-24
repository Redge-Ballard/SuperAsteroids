package edu.byu.cs.superasteroids.model;

/** Ship cannon class
 *

 */
public class ShipCannon extends ShipPartAttachable {

    private int emitX;
    private int emitY;
    private String imageAttPath;
    private int imageAttWidth;
    private int imageAttHeight;
    private String soundPath;
    private int damage;

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

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
