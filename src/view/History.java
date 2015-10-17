package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class History extends ScrollPane{

	private ConsoleUI myConsole;
	private List<Button> myHistoryButtons = new ArrayList<Button>();
	private List<String> myHistoryButtonString = new ArrayList<String>();
	private VBox myVbox = new VBox();

	public History(ConsoleUI console, Scene scene){
		myConsole = console;
	
		this.setPrefWidth(scene.getWidth()/7);
		this.getChildren().add(myVbox);
		this.setContent(myVbox);
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	}

	public void addHistory(String history){
		if(!myHistoryButtonString.contains(history)) {
			Button newHistoryButton = new Button(history);
			myHistoryButtons.add(newHistoryButton);
			myHistoryButtonString.add(history);
			myVbox.getChildren().add(newHistoryButton);
			addButtonEvent(newHistoryButton);
		}
	}


	public void addButtonEvent(Button b){
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				String buttonText = b.getText();
				myConsole.setConsoleText(buttonText);
			}

		});
	}

}
