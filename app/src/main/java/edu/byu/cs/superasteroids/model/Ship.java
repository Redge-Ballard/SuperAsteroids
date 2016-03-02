package edu.byu.cs.superasteroids.model;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.game.InputManager;

/**
 * Created by Azulius on 2/24/16.
 */
public class Ship extends MovingObject {

    private static Map<String, Integer> partsMap = new HashMap<>();
    private static ShipBody body;
    private static ShipCannon cannon;
    private static ShipCore core;
    private static ShipEngine engine;
    private static ShipExtra extra;
    private static int x;
    private static int y;
    private static PointF currentLocation = new PointF();
    private static PointF moveTo = new PointF();
    private static float angleDegree;
    private static float angleRadian;
    private static Rect bounds = new Rect();
    private static float scale = 0.25f;

    private static boolean bodySet = false;
    private static boolean cannonSet = false;
    private static boolean coreSet = false;
    private static boolean engineSet = false;
    private static boolean extraSet = false;

    public static void update() {

        if (InputManager.movePoint != null){
            currentLocation.set(Ship.getX(),Ship.getY());
            PointF movePointWorld = new PointF();
            movePointWorld.set(InputManager.movePoint.x + ViewPort.getXPos(), InputManager.movePoint.y + ViewPort.getYPos());
            moveTo.set(movePointWorld.x-currentLocation.x, movePointWorld.y-currentLocation.y);
            if(moveTo.x != 0 && moveTo.y != 0){
                angleRadian = (float) (Math.atan2(moveTo.y, moveTo.x)+(Math.PI/2));
                angleDegree = (float) (Math.atan2(moveTo.y, moveTo.x)*(180/Math.PI))+90;
            }
        }
    }

    public static void draw() {
        int centerX = DrawingHelper.getGameViewWidth()/2;
        int centerY = DrawingHelper.getGameViewHeight()/2;
        drawBody(centerX, centerY, angleDegree, scale, partsMap);
        drawCannon(centerX, centerY, angleDegree, scale, partsMap);
        drawEngine(centerX, centerY, angleDegree, scale, partsMap);
        drawExtra(centerX, centerY, angleDegree, scale, partsMap);
        Point posb = new Point(50,150);
        DrawingHelper.drawText(posb, Ship.x + " " + Ship.y, 0xffffff, 12);
        if (InputManager.movePoint != null){
            Point pos = new Point(50,50);
            DrawingHelper.drawText(pos, InputManager.movePoint.toString(), 0xffffff, 12);
        }
    }

    public static void drawBody(int x, int y, float angle, float scale, Map<String, Integer> partsId){
        DrawingHelper.drawImage(partsId.get("body"), x, y, angle, scale, scale, 255);
    }

    public static void drawCannon(int x, int y, float angle, float scale, Map<String, Integer> partsId){
        int xPoint = (Ship.getBody().getCannonAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getCannon().getImageWidth()/2-Ship.getCannon().getAttachX());
        int xScaled = (int)(xPoint * scale);
        int yPoint = (Ship.getBody().getCannonAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getCannon().getImageHeight()/2-Ship.getCannon().getAttachY());
        int yScaled = (int)(yPoint * scale);
        PointF partOffset = new PointF(xScaled,yScaled);
        PointF rotatedOffset = GraphicsUtils.rotate(partOffset, angleRadian);
        DrawingHelper.drawImage(partsId.get("cannon"), x + rotatedOffset.x, y + rotatedOffset.y, angle, scale, scale, 255);
    }

    public static void drawEngine(int x, int y, float angle, float scale, Map<String, Integer> partsId){
        int xPoint = (Ship.getBody().getEngineAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getEngine().getImageWidth()/2-Ship.getEngine().getAttachX());
        int xScaled = (int)(xPoint * scale);
        int yPoint = (Ship.getBody().getEngineAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getEngine().getImageHeight()/2-Ship.getEngine().getAttachY());
        int yScaled = (int)(yPoint * scale);
        PointF partOffset = new PointF(xScaled,yScaled);
        PointF rotatedOffset = GraphicsUtils.rotate(partOffset, angleRadian);
        DrawingHelper.drawImage(partsId.get("engine"), x + rotatedOffset.x, y + rotatedOffset.y, angle, scale, scale, 255);
    }

    public static void drawExtra(int x, int y, float angle, float scale, Map<String, Integer> partsId){
        int xPoint = (Ship.getBody().getExtraAttachX()-Ship.getBody().getImageWidth()/2)+(Ship.getExtra().getImageWidth()/2-Ship.getExtra().getAttachX());
        int xScaled = (int)(xPoint * scale);
        int yPoint = (Ship.getBody().getExtraAttachY()-Ship.getBody().getImageHeight()/2)+(Ship.getExtra().getImageHeight()/2-Ship.getExtra().getAttachY());
        int yScaled = (int)(yPoint * scale);
        PointF partOffset = new PointF(xScaled,yScaled);
        PointF rotatedOffset = GraphicsUtils.rotate(partOffset, angleRadian);
        DrawingHelper.drawImage(partsId.get("extra"), x + rotatedOffset.x, y + rotatedOffset.y, angle, scale, scale, 255);
    }

    public static Map<String, Integer> getPartsMap() {
        return partsMap;
    }

    public static void setPartsMap(Map<String, Integer> partsMap) {
        Ship.partsMap = partsMap;
    }

    public static ShipBody getBody() {
        return body;
    }

    public static void setBody(ShipBody body) {
        Ship.body = body;
    }

    public static ShipCannon getCannon() {
        return cannon;
    }

    public static void setCannon(ShipCannon cannon) {
        Ship.cannon = cannon;
    }

    public static ShipCore getCore() {
        return core;
    }

    public static void setCore(ShipCore core) {
        Ship.core = core;
    }

    public static ShipEngine getEngine() {
        return engine;
    }

    public static void setEngine(ShipEngine engine) {
        Ship.engine = engine;
    }

    public static ShipExtra getExtra() {
        return extra;
    }

    public static void setExtra(ShipExtra extra) {
        Ship.extra = extra;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Ship.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Ship.y = y;
    }

    public static Rect getBounds() {
        return bounds;
    }

    public static void setBounds(Rect bounds) {
        Ship.bounds = bounds;
    }

    public static boolean isComplete() {
        if (bodySet && cannonSet && coreSet && engineSet && extraSet){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isBodySet() {
        return bodySet;
    }

    public static void bodyAdded() {
        bodySet = true;
    }

    public boolean isCannonSet() {
        return cannonSet;
    }

    public static void cannonAdded() {
        cannonSet = true;
    }

    public boolean isCoreSet() {
        return coreSet;
    }

    public static void coreAdded() {
        coreSet = true;
    }

    public boolean isEngineSet() {
        return engineSet;
    }

    public static void engineAdded() {
        engineSet = true;
    }

    public boolean isExtraSet() {
        return extraSet;
    }

    public static void extraAdded() {
        extraSet = true;
    }
}
