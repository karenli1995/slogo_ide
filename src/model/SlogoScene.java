package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.scene.paint.Color;

public class SlogoScene extends Observable{
	
	private History myHistory;
	private UserCommands myUserCommands;
	private List<SlogoObjects> myTurtles = new ArrayList<SlogoObjects>();
	
	Color myColor;
	
	SlogoScene(){
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		myHistory = new History();
		myUserCommands = new UserCommands();
		setMyColor(Color.ALICEBLUE);
	}
	
	public void addTurtle(SlogoObjects obj){
		myTurtles.add(obj);
	}
	
	public List<SlogoObjects> getAllTurtles(){
		return myTurtles;
	}
	
	//
	public void setTurtle(int turtleId, SlogoObjects turtle){
		myTurtles.set(turtleId, turtle);
		setChanged();
		notifyObservers();
	}
	
	public SlogoObjects getTurtle(int turtId) {
		return myTurtles.get(turtId);
	}
	
	public void setMyColor(Color color){
		myColor = color;
		setChanged();
		notifyObservers();
	}
	
	public Color getMyColor(){
		return myColor;
	}

}
