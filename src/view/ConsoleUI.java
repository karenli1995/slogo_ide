package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ConsoleUI extends BorderPane{
	TabPane myTabPane;
	Tab myTab;
	TextArea myTextArea;
	
	private int myTextWidth = 800;
	private int myTextHeight = 800;
	private int myTextPosX = 300;
	private int myTextPosY = 10;
	
	ConsoleUI(){
		myTabPane = new TabPane();
		myTabPane.setTranslateX(myTextPosX);
		myTabPane.setTranslateY(myTextPosY);
		
		createTabAndText();
		
		this.setWidth(myTextWidth);
		this.setHeight(myTextHeight);
		this.setCenter(myTabPane);
	}
	
	private void createTabAndText()
	{
		myTab = new Tab();
		myTab.setText("Project 1");
		myTextArea = new TextArea();
		myTextArea.setPrefSize(myTextWidth, myTextHeight);
		myTextArea.setWrapText(true);
		myTextArea.setEditable(true);
		myTab.setContent(myTextArea);
		myTabPane.getTabs().add(myTab);
	}

}
