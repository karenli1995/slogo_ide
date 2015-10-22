package view.console;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import model.MathCommand;
import javafx.scene.Scene;

public class Prompt extends ConsoleTabPane implements Observer{

	public Prompt(Scene scene, ResourceBundle resource) {
		super(scene);
		myFirstTab.setText(resource.getString("PROMPT"));
		myTextArea.setEditable(false);
	}
	
	private void setPromptText(String text){
		myTextArea.setText(text);
	}

	@Override
	public void update(Observable o, Object arg) {
		MathCommand mathValue = (MathCommand) o;
		
		double currValue = mathValue.getMathValue();
		this.setPromptText(currValue + "");
	}

}
