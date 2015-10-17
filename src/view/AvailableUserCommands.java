package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

public class AvailableUserCommands extends VBox{
	
	private ScrollPane myScroller = new ScrollPane();
	private VBox myVBox = new VBox();
	
	public AvailableUserCommands(ConsoleUI console, Scene scene){
		this.setPrefWidth(scene.getWidth()/7);
		this.setPrefHeight(scene.getHeight()*4/5);
		this.getChildren().add(new Label("User Defined Info"));
		
		myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		myScroller.setPrefHeight(scene.getHeight()*4/5);
		myScroller.setContent(myVBox);
		this.getChildren().add(myScroller);
		
	}
	
}
