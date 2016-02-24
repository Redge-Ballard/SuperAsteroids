package edu.byu.cs.superasteroids.model;

/** Ship power core class
 *

 */
public class ShipCore {

    private int cannonBoost;
    private int engineBoost;
    private String imagePath;

    public ShipCore(int cannonBoost, int engineBoost, String imagePath){
        this.cannonBoost = cannonBoost;
        this.engineBoost = engineBoost;
        this.imagePath = imagePath;
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
