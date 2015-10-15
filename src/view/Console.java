package view;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class Console extends ConsoleTabPane {
	
	public Console(Scene scene){
		super(scene);
		myFirstTab.setText("Console");
	}
	public String getTextFromConsole(){
		String currText = this.getSelectionModel().getSelectedItem().getContent().getAccessibleText();
		return currText;
	}
	
	public void clearTextFromConsole(){
		TextArea currTextArea = (TextArea) this.getSelectionModel().getSelectedItem().getContent();
		currTextArea.clear();
	}
	
	public void setConsoleText(String text){
		TextArea currTextArea = (TextArea) this.getSelectionModel().getSelectedItem().getContent();

		String currText = currTextArea.getAccessibleText();
		String newText = "";
		if(currText == null){ newText = text;} else{ newText = currText + text; }
		
		currTextArea.setText(newText);
	}

}
