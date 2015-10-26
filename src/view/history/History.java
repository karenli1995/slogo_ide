package view.history;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import view.GUIManager;
import view.console.ConsoleUI;


public class History extends PastCommandsAbstract {

    public History (GUIManager guiManager, Scene scene, ResourceBundle resource) {
        super(guiManager, scene, resource);
        addLabel("HISTBAR");
    }

}
