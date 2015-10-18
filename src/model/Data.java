package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.Command;
import controller.ParseTreeNode;

public class Data {

	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails = new ArrayList<Trail>();
	private boolean myError = false;
	private String myErrorMessage;
	private List<String> myUserHistory;
	private Map<String, Double> myVariableMap;
	private Map<String, ParseTreeNode<Command>> myUserCommandMap;

	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		myTrails.add(defaultTurtle.getTrail());

		myUserHistory = new ArrayList<String>();
		myVariableMap = new HashMap<String, Double>();
		myUserCommandMap = new HashMap<String, ParseTreeNode<Command>>();
	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
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

	public List<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	public Trail getTrail(int turtleId) {
		return myTrails.get(turtleId);
	}

	public String getErrorMessage() {
		return myErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.myErrorMessage = errorMessage;
	}

	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		this.myError = error;
	}

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		this.myUserHistory = userHistory;
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
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
	}

	public Map<String, ParseTreeNode<Command>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public void setUserCommandMap(Map<String, ParseTreeNode<Command>> userCommandMap) {
		this.myUserCommandMap = userCommandMap;
	}

}
