package edu.byu.cs.superasteroids.main_menu;

import edu.byu.cs.superasteroids.base.IController;

/**
 * Created by Azulius on 2/24/16.
 */
public class MainMenuView implements IMainMenuView {

    public MainMenuView(MainMenuController controller){
        setController(controller);
    }

    @Override
    public void startGame() {

    }

    @Override
    public IController getController() {
        return null;
    }

    @Override
    public void setController(IController controller) {

    }
}
