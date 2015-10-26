package view.history;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import view.console.ConsoleUI;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public abstract class PastCommandsAbstract extends VBox implements PastCommandsInterface {

    private Scene myScene;
    private ConsoleUI myConsole;
    private ResourceBundle myResource;
    private ScrollPane myScroller = new ScrollPane();
    private List<Button> myAllButtons = new ArrayList<Button>();
    private List<String> myButtonStrings = new ArrayList<String>();
    private VBox myVbox = new VBox();

    PastCommandsAbstract (ConsoleUI console, Scene scene, ResourceBundle resource) {
        myScene = scene;
        myResource = resource;
        myConsole = console;
        myScroller.setPrefHeight(scene.getHeight() * 4 / 5);
        myScroller.setContent(myVbox);
        myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        this.setPrefWidth(scene.getWidth() / 7);
        this.getChildren().add(myScroller);
        this.getChildren().add(myVbox);
    }

    protected void addLabel (String name) {
        Label label = new Label(myResource.getString(name));
        label.setPrefWidth(myScene.getWidth() / 7);
        label.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(0),
                                                              new Insets(0))));
        this.getChildren().add(label);
    }

    @Override
    public void addCommand (String name) {
        if (!myButtonStrings.contains(name)) {
            myButtonStrings.add(name);
            Button newButton = new Button(name);
            myAllButtons.add(newButton);
            myVbox.getChildren().add(newButton);
            addButtonEvent(newButton);
        }
    }

    @Override
    public void clear () {
        myVbox.getChildren().removeAll(myAllButtons);
    }

    protected void addButtonEvent (Button b) {
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle (MouseEvent event) {
                String buttonText = b.getText();
                String currConsoleText = myConsole.getTextFromConsole();
                myConsole.setConsoleText(currConsoleText + buttonText);
            }

        });
    }

}
