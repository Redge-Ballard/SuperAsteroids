package edu.byu.cs.superasteroids.model;

import java.util.ArrayList;

/**
 * Created by Azulius on 2/24/16.
 */
public class Ship extends MovingObject {

    private static ShipBody body;
    private static ShipCannon cannon;
    private static ShipCore core;
    private static ShipEngine engine;
    private static ShipExtra extra;

    private static boolean bodySet = false;
    private static boolean cannonSet = false;
    private static boolean coreSet = false;
    private static boolean engineSet = false;
    private static boolean extraSet = false;

    public static void init() {
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
