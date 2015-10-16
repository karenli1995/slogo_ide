package view;

import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConsoleUI extends GridPane{
//	private GUIManager myGUIManager;
	private Console myConsole;
	private Prompt myPrompt;
	private Buttons myButtonsOnGUI;

	
	public ConsoleUI(Scene scene, ModelController controller, GUIManager guimanager, ResourceBundle resource, History history){
		super();
		this.setPrefHeight(scene.getHeight()/5);
		myPrompt = new Prompt(scene, resource);
		myConsole = new Console(scene, resource);
		myButtonsOnGUI = new Buttons(this, controller,scene, guimanager, resource, history);
		this.add(myConsole, 1, 1);
		this.add(myPrompt, 3, 1);
		this.add(myButtonsOnGUI, 2, 1);
		}
	
	public String getTextFromConsole(){
		return myConsole.getTextFromConsole();
	}
	
	public void clearTextFromConsole(){
		myConsole.clearTextFromConsole();
	}
	
	public void setConsoleText(String text){
		myConsole.setConsoleText(text);
	}

}
