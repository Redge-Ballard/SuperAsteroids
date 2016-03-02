package edu.byu.cs.superasteroids.model;

import android.graphics.Point;
import android.graphics.Rect;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * Created by Azulius on 2/27/16.
 */
public class ViewPort {

    private static int width;
    private static int height;
    private static int xPos;
    private static int yPos;
    private Rect bounding = new Rect();

    public static void update(){
        xPos = Ship.getX()-(width/2);
        yPos = Ship.getY()-(height/2);
    }

    public static void draw(){
        width = DrawingHelper.getGameViewWidth();
        height = DrawingHelper.getGameViewHeight();
        Point pos = new Point(50,100);
        DrawingHelper.drawText(pos, xPos + " " + yPos, 0xffffff, 12);
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        ViewPort.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        ViewPort.height = height;
    }

    public static int getXPos() {
        return xPos;
    }

    public static void setxPos(int xPos) {
        ViewPort.xPos = xPos;
    }

    public static int getYPos() {
        return yPos;
    }

    public static void setyPos(int yPos) {
        ViewPort.yPos = yPos;
    }

    public Rect getBounding() {
        return bounding;
    }

    public void setBounding(Rect bounding) {
        this.bounding = bounding;
    }
}
