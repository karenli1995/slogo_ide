package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class History extends ScrollPane{
	private int myWidth = 500;
	private int myHeight = 900;

	private ConsoleUI myConsole;
	private List<Button> myHistoryButtons = new ArrayList<Button>();
	private VBox myVbox = new VBox();

	History(ConsoleUI console){
		myConsole = console;

		this.setPrefWidth(myWidth);
		this.setPrefHeight(myHeight);

		addHistory("fd 50 rt 100");
		addHistory("fd 70 rt 100");

		this.getChildren().add(myVbox);
		this.setContent(myVbox);

		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);

		addButtonEvents();
	}

	public void addHistory(String history){
		Button newHistoryButton = new Button(history);
		myHistoryButtons.add(newHistoryButton);
		myVbox.getChildren().add(newHistoryButton);
	}


	public void addButtonEvents(){
		for(Button b : myHistoryButtons){
			b.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					String buttonText = b.getText();
					myConsole.setConsoleText(buttonText);


				}

			});
		}
	}

}
