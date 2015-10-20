package model;

import javafx.scene.paint.Color;

public class SlogoScene {
	
	History myHistory;
	UserCommands myUserCommands;
	
	Color myColor;
	
	SlogoScene(){
		myHistory = new History();
		myUserCommands = new UserCommands();
	}
	
	public void setMyColor(Color color){
		myColor = color;
	}
	
	public Color getMyColor(){
		return myColor;
	}

}
