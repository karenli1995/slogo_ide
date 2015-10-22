package view.console;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;
import model.MathCommand;
import model.SlogoScene;
import javafx.scene.Scene;

public class Prompt extends ConsoleTabPane implements Observer{
	private TurtleScene myTurtScene;

	public Prompt(Scene scene, ResourceBundle resource, TurtleScene turtScene) {
		super(scene);
		myFirstTab.setText(resource.getString("PROMPT"));
		myTextArea.setEditable(false);
		myTurtScene = turtScene;
	}
	
	private void setPromptText(String text){
		myTextArea.setText(text);
	}

	@Override
	public void update(Observable o, Object arg) {
		SlogoScene scene = (SlogoScene) o;
		
		int tabId = myTurtScene.getIdOfTab();
		TurtleSceneTab tab = myTurtScene.getCurrTab();
		
		double currValue = scene.getData(tabId).getCommandValue();
		this.setPromptText(currValue + "");
	}

}
