package view;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public abstract class ConsoleTabPane extends TabPane{
	
	protected TextArea myTextArea;
	protected Tab myFirstTab;
	
	public ConsoleTabPane(Scene scene){
		super();
		this.setPrefWidth(scene.getWidth()*5/11);
		myFirstTab = new Tab();
		myTextArea = new TextArea();
		myTextArea = new TextArea();
		myTextArea.setWrapText(true);
		myTextArea.setEditable(true);
		myFirstTab.setContent(myTextArea);
		this.getTabs().add(myFirstTab);
	}
}

