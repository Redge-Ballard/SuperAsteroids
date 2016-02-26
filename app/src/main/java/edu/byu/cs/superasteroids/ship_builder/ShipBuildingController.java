package edu.byu.cs.superasteroids.ship_builder;

import java.util.ArrayList;
import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.Asteroid;
import edu.byu.cs.superasteroids.model.AsteroidsGame;
import edu.byu.cs.superasteroids.model.Ship;

/**
 * Created by Azulius on 2/24/16.
 */
public class ShipBuildingController implements IShipBuildingController{

    private IShipBuildingView View;
    private IShipBuildingView.PartSelectionView currentView;

    private int pickedBody = -1;
    private int pickedCannon = -1;
    private int pickedEngine = -1;
    private int pickedCore = -1;
    private int pickedExtra = -1;

    private ArrayList<Integer> bodyIds = new ArrayList<Integer>();
    private ArrayList<Integer> cannonIds = new ArrayList<Integer>();
    private ArrayList<Integer> engineIds = new ArrayList<Integer>();
    private ArrayList<Integer> coreIds = new ArrayList<Integer>();
    private ArrayList<Integer> extraIds = new ArrayList<Integer>();

    public ShipBuildingController(IShipBuildingView activity){
        setView(activity);
    }

    @Override
    public void onViewLoaded(IShipBuildingView.PartSelectionView partView) {
        switch (partView) {
            case MAIN_BODY:
                currentView = partView;
                View.setArrow(IShipBuildingView.PartSelectionView.MAIN_BODY, IShipBuildingView.ViewDirection.LEFT, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.MAIN_BODY, IShipBuildingView.ViewDirection.RIGHT, true, "Cannons");
                View.setArrow(IShipBuildingView.PartSelectionView.MAIN_BODY, IShipBuildingView.ViewDirection.DOWN, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.MAIN_BODY, IShipBuildingView.ViewDirection.UP, false, "");
                View.setPartViewImageList(IShipBuildingView.PartSelectionView.MAIN_BODY, bodyIds);
                break;
            case CANNON:
                currentView = partView;
                View.setArrow(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.LEFT, true, "Main Bodies");
                View.setArrow(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.RIGHT, true, "Engines");
                View.setArrow(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.DOWN, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.UP, false, "");
                View.setPartViewImageList(IShipBuildingView.PartSelectionView.CANNON, cannonIds);
                break;
            case ENGINE:
                currentView = partView;
                View.setArrow(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.LEFT, true, "Cannons");
                View.setArrow(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.RIGHT, true, "Power Cores");
                View.setArrow(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.DOWN, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.UP, false, "");
                View.setPartViewImageList(IShipBuildingView.PartSelectionView.ENGINE, engineIds);
                break;
            case POWER_CORE:
                currentView = partView;
                View.setArrow(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.LEFT, true, "Engines");
                View.setArrow(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.RIGHT, true, "Extra Parts");
                View.setArrow(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.DOWN, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.UP, false, "");
                View.setPartViewImageList(IShipBuildingView.PartSelectionView.POWER_CORE, coreIds);
                break;
            case EXTRA_PART:
                currentView = partView;
                View.setArrow(IShipBuildingView.PartSelectionView.EXTRA_PART, IShipBuildingView.ViewDirection.LEFT, true, "Power Core");
                View.setArrow(IShipBuildingView.PartSelectionView.EXTRA_PART, IShipBuildingView.ViewDirection.RIGHT, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.EXTRA_PART, IShipBuildingView.ViewDirection.DOWN, false, "");
                View.setArrow(IShipBuildingView.PartSelectionView.EXTRA_PART, IShipBuildingView.ViewDirection.UP, false, "");
                View.setPartViewImageList(IShipBuildingView.PartSelectionView.EXTRA_PART, extraIds);
                break;
        }
    }

    @Override
    public void update(double elapsedTime) {

    }

    @Override
    public void loadContent(ContentManager content) {
        if (content != null) {
            if(bodyIds.size() == 0) {
                bodyIds.add(content.loadImage(AsteroidsGame.getBodies().get(0).getImagePath()));
                bodyIds.add(content.loadImage(AsteroidsGame.getBodies().get(1).getImagePath()));
            }
            if(cannonIds.size() == 0) {
                cannonIds.add(content.loadImage(AsteroidsGame.getCannons().get(0).getImagePath()));
                cannonIds.add(content.loadImage(AsteroidsGame.getCannons().get(1).getImagePath()));
            }
            if(engineIds.size() == 0) {
                engineIds.add(content.loadImage(AsteroidsGame.getEngines().get(0).getImagePath()));
                engineIds.add(content.loadImage(AsteroidsGame.getEngines().get(1).getImagePath()));
            }
            if(coreIds.size() == 0) {
                coreIds.add(content.loadImage(AsteroidsGame.getCores().get(0).getImagePath()));
                coreIds.add(content.loadImage(AsteroidsGame.getCores().get(1).getImagePath()));
            }
            if(extraIds.size() == 0) {
                extraIds.add(content.loadImage(AsteroidsGame.getExtras().get(0).getImagePath()));
                extraIds.add(content.loadImage(AsteroidsGame.getExtras().get(1).getImagePath()));
            }
        }
    }

    @Override
    public void unloadContent(ContentManager content) {

    }

    @Override
    public void draw() {
        if (pickedBody >= 0) {
            DrawingHelper.drawImage(bodyIds.get(pickedBody), DrawingHelper.getGameViewWidth() / 2, DrawingHelper.getGameViewHeight() / 2, 0, 0.5f, 0.5f, 255);
        }
        if (pickedCannon >= 0) {
            DrawingHelper.drawImage(cannonIds.get(pickedCannon), DrawingHelper.getGameViewWidth() / 2, DrawingHelper.getGameViewHeight() / 2, 0, 0.5f, 0.5f, 255);
        }
        if (pickedEngine >= 0) {
            DrawingHelper.drawImage(engineIds.get(pickedEngine), DrawingHelper.getGameViewWidth() / 2, DrawingHelper.getGameViewHeight() / 2, 0, 0.5f, 0.5f, 255);
        }
        if (pickedCore >= 0) {
            DrawingHelper.drawImage(coreIds.get(pickedCore), DrawingHelper.getGameViewWidth() / 2, DrawingHelper.getGameViewHeight() / 2, 0, 0.5f, 0.5f, 255);
        }
        if (pickedExtra >= 0) {
            DrawingHelper.drawImage(extraIds.get(pickedExtra), DrawingHelper.getGameViewWidth() / 2, DrawingHelper.getGameViewHeight() / 2, 0, 0.5f, 0.5f, 255);
        }
    }

    @Override
    public void onSlideView(IShipBuildingView.ViewDirection direction) {
        switch (currentView){
            case MAIN_BODY:
                if (direction == IShipBuildingView.ViewDirection.LEFT){
                    View.animateToView(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.RIGHT);
                }
                break;
            case CANNON:
                if (direction == IShipBuildingView.ViewDirection.RIGHT){
                    View.animateToView(IShipBuildingView.PartSelectionView.MAIN_BODY, IShipBuildingView.ViewDirection.LEFT);
                }
                if (direction == IShipBuildingView.ViewDirection.LEFT){
                    View.animateToView(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.RIGHT);
                }
                break;
            case ENGINE:
                if (direction == IShipBuildingView.ViewDirection.RIGHT){
                    View.animateToView(IShipBuildingView.PartSelectionView.CANNON, IShipBuildingView.ViewDirection.LEFT);
                }
                if (direction == IShipBuildingView.ViewDirection.LEFT){
                    View.animateToView(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.RIGHT);
                }
                break;
            case POWER_CORE:
                if (direction == IShipBuildingView.ViewDirection.RIGHT){
                    View.animateToView(IShipBuildingView.PartSelectionView.ENGINE, IShipBuildingView.ViewDirection.LEFT);
                }
                if (direction == IShipBuildingView.ViewDirection.LEFT){
                    View.animateToView(IShipBuildingView.PartSelectionView.EXTRA_PART, IShipBuildingView.ViewDirection.RIGHT);
                }
                break;
            case EXTRA_PART:
                if (direction == IShipBuildingView.ViewDirection.RIGHT){
                    View.animateToView(IShipBuildingView.PartSelectionView.POWER_CORE, IShipBuildingView.ViewDirection.LEFT);
                }
                break;
        }
    }

    @Override
    public void onPartSelected(int index) {
        switch(currentView){
            case MAIN_BODY:
                Ship.bodyAdded();
                Ship.setBody(AsteroidsGame.getBodies().get(index));
                pickedBody = index;
                if (Ship.isComplete() == true){
                    View.setStartGameButton(true);
                }
                break;
            case CANNON:
                Ship.cannonAdded();
                Ship.setCannon(AsteroidsGame.getCannons().get(index));
                pickedCannon = index;
                if (Ship.isComplete() == true){
                    View.setStartGameButton(true);
                }
                break;
            case ENGINE:
                Ship.engineAdded();
                Ship.setEngine(AsteroidsGame.getEngines().get(index));
                pickedEngine = index;
                if (Ship.isComplete() == true){
                    View.setStartGameButton(true);
                }
                break;
            case POWER_CORE:
                Ship.coreAdded();
                Ship.setCore(AsteroidsGame.getCores().get(index));
                pickedCore = index;
                if (Ship.isComplete() == true){
                    View.setStartGameButton(true);
                }
                break;
            case EXTRA_PART:
                Ship.extraAdded();
                Ship.setExtra(AsteroidsGame.getExtras().get(index));
                pickedExtra = index;
                if (Ship.isComplete() == true){
                    View.setStartGameButton(true);
                }
                break;
        }
    }

    @Override
    public void onStartGamePressed() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public IView getView() {
        return View;
    }

    @Override
    public void setView(IView view) {
        this.View = (IShipBuildingView) view;
    }
}
