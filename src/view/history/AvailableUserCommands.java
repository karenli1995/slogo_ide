package view.history;

import java.util.ResourceBundle;
import view.console.ConsoleUI;
import javafx.scene.Scene;


public class AvailableUserCommands extends PastCommandsAbstract {

    public AvailableUserCommands (ConsoleUI console, Scene scene, ResourceBundle resource) {
        super(console, scene, resource);
        addLabel("USERINFO");
    }

}
