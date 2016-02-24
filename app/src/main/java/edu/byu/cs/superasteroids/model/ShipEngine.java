package edu.byu.cs.superasteroids.model;

/** Ship engine class
 *

 */
public class ShipEngine extends ShipPartAttachable {

    private int speed;
    private int turnRate;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTurnRate() {
        return turnRate;
    }

    public void setTurnRate(int turnRate) {
        this.turnRate = turnRate;
    }

}
