package view.console;

import java.util.ResourceBundle;
import view.GUIManager;
import view.buttons.AllButtons;
import view.scene.TurtleScene;
import controller.ModelController;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class ConsoleUI extends GridPane {
    // private GUIManager myGUIManager;
    private Console myConsole;
    private Prompt myPrompt;
    private AllButtons myButtonsOnGUI;

    public ConsoleUI (Scene scene,
                      ModelController controller,
                      GUIManager guimanager,
                      ResourceBundle resource,
                      TurtleScene turtScene) {
        super();
        this.setPrefHeight(scene.getHeight() / 5);
        myPrompt = new Prompt(scene, resource, turtScene);
        myConsole = new Console(scene, resource);
        myButtonsOnGUI = new AllButtons(this, controller, scene, guimanager, resource);
        this.add(myConsole, 1, 1);
        this.add(myPrompt, 3, 1);
        this.add(myButtonsOnGUI, 2, 1);
    }

    public Prompt getPrompt () {
        return myPrompt;
    }

    public String getTextFromConsole () {
        return myConsole.getTextFromConsole();
    }

    public void clearTextFromConsole () {
        myConsole.clearTextFromConsole();
    }

    public void setConsoleText (String text) {
        myConsole.setConsoleText(text);
    }

}
