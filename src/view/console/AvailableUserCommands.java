package view.console;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

public class AvailableUserCommands extends VBox {

	private ScrollPane myScroller = new ScrollPane();
	private VBox myVBox = new VBox();
	private ConsoleUI myConsole;

	public AvailableUserCommands(ConsoleUI console, Scene scene) {
		this.setPrefWidth(scene.getWidth() / 7);
		this.setPrefHeight(scene.getHeight() * 4 / 5);
		this.getChildren().add(new Label("User Defined Info"));
		myConsole = console;
		myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		myScroller.setPrefHeight(scene.getHeight() * 4 / 5);
		myScroller.setContent(myVBox);
		this.getChildren().add(myScroller);

	}
	
	public void add(String name){
		Button newUserButton = new Button(name);
		myVBox.getChildren().add(newUserButton);
		addButtonEvent(newUserButton);
	}
	
	private void addButtonEvent(Button b) {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				String buttonText = b.getText();
				myConsole.setConsoleText(buttonText);
			}

		});
	}

}
