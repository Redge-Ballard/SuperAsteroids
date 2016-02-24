package edu.byu.cs.superasteroids.model;

/** Asteroid runtime class
 *
 */
public class Asteroid extends ImageObject {

    /** Represents which type of asteroid */
    private String type;

    /** Updates the objects position and stats
     *
     */
    public void update(){
    }

    /** Draws the object on the screen
     *
     */
    public void draw(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
