package view.buttons;

import java.util.ResourceBundle;
import view.GUIManager;
import view.console.ConsoleUI;
import controller.ModelController;


public class ClearHistoryButton extends AbstractButton {

    ClearHistoryButton (ConsoleUI console,
                        ModelController controller,
                        GUIManager guimanager,
                        ResourceBundle resource,
                        String buttonName) {
        super(console, controller, guimanager, resource, buttonName);
    }

    @Override
    protected void action () {
        myGUIManager.getMyHistory().clear();
    }

}
