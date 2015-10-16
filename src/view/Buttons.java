package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import model.Data;
import model.Location;
import controller.ModelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Buttons extends VBox {
	private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);
	private String[] BUTTON_NAMES = new String[2]; 
	
	private History myHistory;
	private GUIManager myGUIManager;
	private Map<String, Button> myButtons;
	private ConsoleUI myConsole;
	private ModelController myController;
	
	public Buttons(ConsoleUI console, ModelController controller,Scene scene,GUIManager guimanager, ResourceBundle resource, History history){
		BUTTON_NAMES[0] = resource.getString("RUN");
		BUTTON_NAMES[1] = resource.getString("CLEAR");
		myConsole = console;
		myController = controller;
		myGUIManager = guimanager;
		myHistory = history;
		addButtons();
		this.setPrefWidth(scene.getWidth()/11);
		this.setPadding(new Insets(scene.getWidth()/40,scene.getWidth()/40,scene.getWidth()/40,scene.getWidth()/40));
		this.setSpacing(20);
		this.setStyle("-fx-background-color: #dbdbdb");
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
		Data data = myController.traverse();
		myHistory.addHistory(consoleText);
	}
	
	private void clearConsole(){
		myConsole.clearTextFromConsole();
	}
	
	private void setAllMargins(Node n){
		HBox.setMargin(n, myInset);
	}
}
