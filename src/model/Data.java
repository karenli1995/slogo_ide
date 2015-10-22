package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import javafx.scene.paint.Color;

public class Data implements Data_Turtle_Interface{

	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails;
	private boolean myError;
	private String myErrorMessage;
	private List<String> myUserHistory;
	private Map<String, Double> myVariableMap;
	private Map<String, ParseTreeNode<CommandInterface>> myUserCommandMap;
	private Color myColor;
	private double myCommandValue;


	public Data() {	
		myTurtles = new ArrayList<SlogoObjects>();
		myTrails = new ArrayList<Trail>();
		
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		setTurtle(0, defaultTurtle); //check
		myTrails.add(defaultTurtle.getTrail());

		setUserHistory(new ArrayList<String>());		
		setVariableMap(new HashMap<String, Double>());
		setUserCommandMap(new HashMap<String, ParseTreeNode<CommandInterface>>());
		
		setError(false);

		myUserHistory = new ArrayList<String>();
		myVariableMap = new HashMap<String, Double>();
		myUserCommandMap = new HashMap<String, ParseTreeNode<CommandInterface>>();

		setMyColor(Color.ALICEBLUE);
	}

	public void setTurtle(int turtleId, SlogoObjects turtle){
		myTurtles.set(turtleId, turtle);
//		setChanged();
//		notifyObservers();
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
//		setChanged();
//		notifyObservers();
	}

	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		this.myError = error;
//		setChanged();
//		notifyObservers();
	}

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		this.myUserHistory = userHistory;
//		setChanged();
//		notifyObservers();
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
//		setChanged();
//		notifyObservers();
	}

	public Map<String, Double> getVariableMap() {
		return myVariableMap;
	}

	public void setVariableMap(Map<String, Double> variableMap) {
		this.myVariableMap = variableMap;
	}

	
	public void updateVaraibleMap(String varName, Double value){
		myVariableMap.put(varName, value);
//		setChanged();
//		notifyObservers();
	}

	public Map<String, ParseTreeNode<CommandInterface>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public void setUserCommandMap(Map<String, ParseTreeNode<CommandInterface>> userCommandMap) {
		this.myUserCommandMap = userCommandMap;
//		setChanged();
//		notifyObservers();
	}

	public void setMyColor(Color color){
		myColor = color;
//		setChanged();
//		notifyObservers();
	}

	public Color getMyColor(){
		return myColor;

	}

	public double getCommandValue() {
		return myCommandValue;
	}

	public void setCommandValue(double commandValue) {
		this.myCommandValue = commandValue;
	}

}
