package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class AvailableUserCommands extends ScrollPane{

	private int myWidth = 500;
	private int myHeight = 900;
	
	AvailableUserCommands(){
		this.setPrefWidth(myWidth);
		this.setPrefHeight(myHeight);
		
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
}
