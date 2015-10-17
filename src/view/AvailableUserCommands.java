package view;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class AvailableUserCommands extends ScrollPane{
	
	public AvailableUserCommands(ConsoleUI console, Scene scene){
		this.setPrefWidth(scene.getWidth()/7);
		this.setPrefHeight(scene.getHeight()*4/5);
		
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
}
