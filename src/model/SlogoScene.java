package model;

import javafx.scene.paint.Color;

public class SlogoScene {
	
	History myHistory;
	UserCommands myUserCommands;
	
	Color myColor;
	
	SlogoScene(){
		myHistory = new History();
		myUserCommands = new UserCommands();
		setMyColor(Color.ALICEBLUE);
	}
	
	public void setMyColor(Color color){
		myColor = color;
	}
	
	public Color getMyColor(){
		return myColor;
	}

}
