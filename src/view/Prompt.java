package view;

import java.util.ResourceBundle;

import javafx.scene.Scene;

public class Prompt extends ConsoleTabPane {
	
	public Prompt(Scene scene, ResourceBundle resource){
		super(scene);
		myFirstTab.setText(resource.getString("PROMPT"));
	}

}
