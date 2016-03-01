package edu.byu.cs.superasteroids.model;

import android.graphics.Rect;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * Created by Azulius on 2/27/16.
 */
public class ViewPort {

    private int width = DrawingHelper.getGameViewWidth();
    private int height = DrawingHelper.getGameViewHeight();
    private int xPos;
    private int yPos;
    private Rect bounding = new Rect();


}
