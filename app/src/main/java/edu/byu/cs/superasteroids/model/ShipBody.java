package edu.byu.cs.superasteroids.model;

/** Ship main body class
 *

 */
public class ShipBody extends ShipPart {

    private int cannonAttachX;
    private int cannonAttachY;
    private int engineAttachX;
    private int engineAttachY;
    private int extraAttachX;
    private int extraAttachY;

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

    public int getExtraAttachX() {
        return extraAttachX;
    }

    public void setExtraAttachX(int extraAttachX) {
        this.extraAttachX = extraAttachX;
    }

    public int getExtraAttachY() {
        return extraAttachY;
    }

    public void setExtraAttachY(int extraAttachY) {
        this.extraAttachY = extraAttachY;
    }
}
