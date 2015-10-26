package view.history;

import java.util.ResourceBundle;
import view.console.ConsoleUI;
import javafx.scene.Scene;


public class History extends PastCommandsAbstract {

    public History (ConsoleUI console, Scene scene, ResourceBundle resource) {
        super(console, scene, resource);
        addLabel("HISTBAR");
    }

}
