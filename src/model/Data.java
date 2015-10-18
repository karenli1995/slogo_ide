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
	private boolean error = false;
	private String errorMessage;
	private List<String> userHistory;
	private Map<String, Double> variableMap = new  HashMap<String, Double>();
	private Map<String, ParseTreeNode<Command>> userCommandMap;
	// private int pen = 0;

	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		setUserHistory(new ArrayList<String>());
		setVariableMap(new HashMap<String, Double>());

		setUserCommandMap(new HashMap<String, ParseTreeNode<Command>>());
		myTrails.add(defaultTurtle.getTrail());


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
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<String> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		this.userHistory = userHistory;
	}

	public void addCommandToHistory(String s) {
		userHistory.add(s);
	}

	public Map<String, Double> getVariableMap() {
		return variableMap;
	}

	public void setVariableMap(Map<String, Double> variableMap) {
		this.variableMap = variableMap;
	}
	public void updateVaraibleMap(String varName, Double value){
		System.out.println("update");
		variableMap.put(varName, value);
	}

	public Map<String, ParseTreeNode<Command>> getUserCommandMap() {
		return userCommandMap;
	}

	public void setUserCommandMap(Map<String, ParseTreeNode<Command>> userCommandMap) {
		this.userCommandMap = userCommandMap;
	}

}
