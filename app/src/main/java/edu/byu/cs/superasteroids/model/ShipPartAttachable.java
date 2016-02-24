package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/23/16.
 */
public class ShipPartAttachable extends ShipPart {

    private int attachX;
    private int attachY;

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
