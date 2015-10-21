package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javafx.scene.paint.Color;
import command.Command;
import controller.ParseTreeNode;

public class Data extends Observable{

	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails;
	private boolean myError;
	private String myErrorMessage;
	private List<String> myUserHistory;
	private Map<String, Double> myVariableMap;
	private Map<String, ParseTreeNode<Command>> myUserCommandMap;
	private Color myColor;

	public Data() {	
		myTurtles = new ArrayList<SlogoObjects>();
		myTrails = new ArrayList<Trail>();
		
		Turtle defaultTurtle = new Turtle();
		defaultTurtle.setIsActive(true);
		myTurtles.add(defaultTurtle);
		setTurtle(0, defaultTurtle); //check
		myTrails.add(defaultTurtle.getTrail());

		setUserHistory(new ArrayList<String>());		
		setVariableMap(new HashMap<String, Double>());
		setUserCommandMap(new HashMap<String, ParseTreeNode<Command>>());
		
		setError(false);
		setMyColor(Color.ALICEBLUE);
	}

	/*
	 * public void addTurtle() { tempTurt = new Turtle();
	 * myTurtles.add(tempTurt);
	 * tempTurtle.getPen().getTrail().addCoord(tempTurtle.getLocation().getPoint
	 * ()); myTrails.add(tempTurtle.getPen().getTrail());
	 *
	 *
	 * }
	 */

//	public List<SlogoObjects> getAllTurtles() {
//		return myTurtles;
//	}
	
	public void setTurtle(int turtleId, SlogoObjects turtle){
		myTurtles.set(turtleId, turtle);
		setChanged();
		notifyObservers();
	}
	
	public SlogoObjects getTurtle(int turtleId){
		return myTurtles.get(turtleId);
	}

	public Trail getTrail(int turtleId) {
		return myTrails.get(turtleId);
	}

	public String getErrorMessage() {
		return myErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.myErrorMessage = errorMessage;
		setChanged();
		notifyObservers();
	}

	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		this.myError = error;
		setChanged();
		notifyObservers();
	}

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		this.myUserHistory = userHistory;
		setChanged();
		notifyObservers();
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
		setChanged();
		notifyObservers();
	}

	public Map<String, Double> getVariableMap() {
		return myVariableMap;
	}

	public void setVariableMap(Map<String, Double> variableMap) {
		this.myVariableMap = variableMap;
	}
	public void updateVaraibleMap(String varName, Double value){
		System.out.println("update");
		myVariableMap.put(varName, value);
		setChanged();
		notifyObservers();
	}

	public Map<String, ParseTreeNode<Command>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public void setUserCommandMap(Map<String, ParseTreeNode<Command>> userCommandMap) {
		this.myUserCommandMap = userCommandMap;
		setChanged();
		notifyObservers();
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
