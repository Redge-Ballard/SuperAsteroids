package edu.byu.cs.superasteroids.model;

/** Ship power core class
 *

 */
public class ShipCore extends ShipPart{

    private int cannonBoost;
    private int engineBoost;

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

    public int getCannonBoost() {
        return cannonBoost;
    }

    public void setCannonBoost(int cannonBoost) {
        this.cannonBoost = cannonBoost;
    }

    public int getEngineBoost() {
        return engineBoost;
    }

    public void setEngineBoost(int engineBoost) {
        this.engineBoost = engineBoost;
    }
}
