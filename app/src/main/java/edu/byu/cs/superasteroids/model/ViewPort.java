package edu.byu.cs.superasteroids.model;

import android.graphics.Point;
import android.graphics.Rect;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * Created by Azulius on 2/27/16.
 */
public class ViewPort {

    private int width;
    private int height;
    private int xPos;
    private int yPos;
    private Rect bounding = new Rect();

    public ViewPort(){
        xPos = 0;
        yPos = 0;
    }

    public void update(){
        xPos = Ship.getX()-(width/2);
        yPos = Ship.getY()-(height/2);
    }

    public void draw(){
        width = DrawingHelper.getGameViewWidth();
        height = DrawingHelper.getGameViewHeight();
        Point pos = new Point(50,100);
        DrawingHelper.drawText(pos, xPos + " " + yPos, 0xffffff, 12);
    }
}
