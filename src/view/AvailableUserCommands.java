package view;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class AvailableUserCommands extends ScrollPane{

	private int myWidth = 500;
	private int myHeight = 900;
	
	public AvailableUserCommands(ConsoleUI console, Scene scene){
		this.setPrefWidth(scene.getWidth()/7);
		this.setPrefHeight(scene.getHeight()*4/5);
		
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
}
