package edu.byu.cs.superasteroids.main_menu;

import edu.byu.cs.superasteroids.base.IView;

/**
 * Created by Azulius on 2/24/16.
 */
public class MainMenuController implements IMainMenuController {

    public MainMenuController(MainActivity activity) {
        setView(activity);
    }

    @Override
    public void onQuickPlayPressed() {

    }

    @Override
    public IView getView() {
        return null;
    }

    @Override
    public void setView(IView view) {

    }
}
