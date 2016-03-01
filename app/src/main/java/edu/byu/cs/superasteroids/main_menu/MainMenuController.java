package edu.byu.cs.superasteroids.main_menu;

import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.model.AsteroidsGame;
import edu.byu.cs.superasteroids.model.Ship;
import edu.byu.cs.superasteroids.ship_builder.ShipBuildingActivity;
import edu.byu.cs.superasteroids.ship_builder.ShipBuildingController;

/**
 * Created by Azulius on 2/24/16.
 */
public class MainMenuController implements IMainMenuController {

    private IMainMenuView view;

    public MainMenuController(MainActivity activity) {
        setView(activity);
    }

    @Override
    public void onQuickPlayPressed() {
        int rando = 0;
        if (Math.random() > 0.5){rando = 1;}
        else {rando = 0;}
        Ship.setBody(AsteroidsGame.getBodies().get(rando));
        if (Math.random() > 0.5){rando = 1;}
        else {rando = 0;}
        Ship.setCannon(AsteroidsGame.getCannons().get(rando));
        if (Math.random() > 0.5){rando = 1;}
        else {rando = 0;}
        Ship.setEngine(AsteroidsGame.getEngines().get(rando));
        if (Math.random() > 0.5){rando = 1;}
        else {rando = 0;}
        Ship.setCore(AsteroidsGame.getCores().get(rando));
        if (Math.random() > 0.5){rando = 1;}
        else {rando = 0;}
        Ship.setExtra(AsteroidsGame.getExtras().get(rando));
        view.startGame();
    }

    @Override
    public IView getView() {
        return null;
    }

    @Override
    public void setView(IView view) {
        this.view = (IMainMenuView) view;
    }
}
