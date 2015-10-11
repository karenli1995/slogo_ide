package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.ModelController;
import data.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons extends HBox {
	private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);
	private static final String[] BUTTON_NAMES = { "Run", "Clear"};
	
	private Map<String, Button> myButtons;
	private ConsoleUI myConsole;
	private ModelController myController;
	
	Buttons(ConsoleUI console, ModelController controller){
		myConsole = console;
		myController = controller;
		addButtons();
	}
	
	/**
	 * Add the control buttons to the screen
	 */
	private void addButtons() {
		myButtons = new HashMap<>(BUTTON_NAMES.length);
		EventHandler<ActionEvent>[] events = new EventHandler[2];
		events[0] = (e) -> runConsole();
		events[1] = (e) -> clearConsole();
		int index;
		for (index = 0; index < events.length; index++) {
			Button button = createAndPlaceButton(BUTTON_NAMES[index], events[index]);
			myButtons.put(button.getText(), button);
			button.setDisable(false);
		}
		//myButtons.get("LoadXML").setDisable(false);
	}
	
	/**
	 * Create the control buttons and place them on the screen
	 * @param property The button text
	 * @param yIndex The index of the button
	 * @param handler The EventHandler associated with the button
	 * @return
	 */
	public Button createAndPlaceButton(String property, EventHandler<ActionEvent> handler) {
		String label = property;// myResources.getString(property);
		Button button = new Button(label);
		
		button.applyCss();
		button.setOnAction(handler);
		
		setAllMargins(button);
		this.getChildren().add(button);
		return button;
	}
	
	
	private void runConsole(){
		String consoleText = myConsole.getTextFromConsole();
		myController.parse(consoleText);
	}
	
	private void clearConsole(){
		myConsole.clearTextFromConsole();
	}
	
	private void setAllMargins(Node n){
		HBox.setMargin(n, myInset);
	}
}
