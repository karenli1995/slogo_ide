package view.history;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import view.GUIManager;
import view.console.ConsoleUI;


public class AvailableUserCommands extends PastCommandsAbstract {

    public AvailableUserCommands (GUIManager guiManager, Scene scene, ResourceBundle resource) {
        super(guiManager, scene, resource);
        addLabel("USERINFO");
    }

}
