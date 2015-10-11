package view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class History extends ScrollPane{

	
	History(){

	}
	
	public void addHistory(String history){
		Button newHistoryButton = new Button(history);
		this.getChildren().add(newHistoryButton);
	}
	
	
	public void getHistory(){
		
	}
	
}
