package view.history;

import java.util.ResourceBundle;
import javafx.scene.Scene;
import view.console.ConsoleUI;


public class History extends PastCommandsAbstract {

    public History (ConsoleUI console, Scene scene, ResourceBundle resource) {
        super(console, scene, resource);
        addLabel("HISTBAR");
    }

}
