package view.history;

import java.util.ResourceBundle;
import javafx.scene.Scene;
import view.console.ConsoleUI;


public class AvailableUserCommands extends PastCommandsAbstract {

    public AvailableUserCommands (ConsoleUI console, Scene scene, ResourceBundle resource) {
        super(console, scene, resource);
        addLabel("USERINFO");
    }

}
