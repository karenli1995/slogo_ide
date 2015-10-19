package view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

public class History extends VBox {

	private ConsoleUI myConsole;
	private ResourceBundle myResource;
	private Button myClearButton;
	private ScrollPane myScroller = new ScrollPane();
	private List<Button> myHistoryButtons = new ArrayList<Button>();
	private List<String> myHistoryButtonString = new ArrayList<String>();
	private VBox myVbox = new VBox();

	public History(ConsoleUI console, Scene scene, ResourceBundle resource) {
		myResource = resource;
		myConsole = console;
		this.setPrefWidth(scene.getWidth() / 7);
		Label label = new Label(myResource.getString("HISTBAR"));
		label.setPrefWidth(scene.getWidth() / 7);
		label.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(0), new Insets(0))));
		this.getChildren().add(label);
		this.getChildren().add(myScroller);
		this.getChildren().add(myVbox);
		myScroller.setPrefHeight(scene.getHeight() * 4 / 5);
		myScroller.setContent(myVbox);
		myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	}

	public void addHistory(String history) {
		if (!myHistoryButtonString.contains(history)) {
			Button newHistoryButton = new Button(history);
			myHistoryButtons.add(newHistoryButton);
			myHistoryButtonString.add(history);
			myVbox.getChildren().add(newHistoryButton);
			addButtonEvent(newHistoryButton);
		}
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

	public void clear() {
		myVbox.getChildren().removeAll(myHistoryButtons);
	}

}
