package model.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.CommandInterface;
import command.commandsObservers.DisplayCommandObserver;
import command.commandsObservers.TurtleCommandsObserver;
import controller.ParseTreeNode;
import javafx.scene.paint.Color;
import model.turtleinfo.SlogoObjects;
import model.turtleinfo.Trail;
import model.turtleinfo.Turtle;

public class Data implements DisplayDataInterface,DataTurtleInterface, ForObserverInterface, ColorDataInterface, Serializable {

	private static final long serialVersionUID = 2437173979976418913L;
	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails;
	private boolean myError;
	private String myErrorMessage;
	private List<String> myUserHistory;
	private Map<String, Double> myVariableMap;
	private Map<String, List<ParseTreeNode<CommandInterface>>> myUserCommandMap;
	private Map<String, List<String>> myCommandVariableMap;
	private transient Color myColor;
	private String myColorHex;
	private double myCommandValue;
	private ActiveTurtles activeTurtles;
	private static int turtleID = 0;
	private static int activeTurtle = 0;
	private static DisplayCommandObserver displayCommands;
	private static TurtleCommandsObserver turtleCommands;

	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		myTrails = new ArrayList<Trail>();

		createTurtle();

		activeTurtles = new ActiveTurtles();
		setUserHistory(new ArrayList<String>());
		setVariableMap(new HashMap<String, Double>());
		setUserCommandMap(new HashMap<String, List<ParseTreeNode<CommandInterface>>>());
		setMyCommandVariableMap(new HashMap<String, List<String>>());

		setError(false);

		myUserHistory = new ArrayList<String>();
		myVariableMap = new HashMap<String, Double>();
		myUserCommandMap = new HashMap<String, List<ParseTreeNode<CommandInterface>>>();

		setMyColor(Color.ALICEBLUE);

		displayCommands = new DisplayCommandObserver(this);
		turtleCommands = new TurtleCommandsObserver(this);

	}

	@Override
	public void createTurtle() {
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		setTurtle(turtleID, defaultTurtle); // check
		myTrails.add(defaultTurtle.getTrail());
		turtleID++;
	}

	@Override
	public void setTurtle(int turtleId, SlogoObjects turtle) {
		myTurtles.set(turtleId, turtle);

	}

	@Override
	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	@Override
	public List<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	public Trail getTrail(int turtleId) {
		return myTrails.get(turtleId);
	}

	@Override
	public int activeTurtleListSize() {
		return activeTurtles.size();
	}

	@Override
	public int activeTurtleListValue(int index) {
		return activeTurtles.getvalue(index);
	}

	@Override
	public void addToActiveList(int value) {
		activeTurtles.update(value);
		setActiveTurtle(value);
	}

	//////
	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		myError = error;
	}

	public void setVariableMap(Map<String, Double> variableMap) {
		myVariableMap = variableMap;
	}

	@Override
	public void updateVariableMap(String varName, Double value) {
		myVariableMap.put(varName, value);
	}

	public void setUserCommandMap(Map<String, List<ParseTreeNode<CommandInterface>>> userCommandMap) {
		myUserCommandMap = userCommandMap;

	}
	///

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		myUserHistory = userHistory;
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
	}

	@Override
	public Color getMyColor() {
		return myColor;

	}

	@Override
	public void setMyColor(Color color) {
		myColor = color;
		myColorHex = color.toString();
	}

	@Override
	public double getCommandValue() {

		return myCommandValue;

	}

	@Override
	public void setCommandValue(double commandValue) {
		myCommandValue = commandValue;
	}

	@Override
	public String getErrorMessage() {
		String temp = myErrorMessage;
		myErrorMessage = null;
		return temp;
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		myErrorMessage = errorMessage;

	}

	@Override
	public Map<String, Double> getVariableMap() {
		return myVariableMap;
	}

	@Override
	public Map<String, List<ParseTreeNode<CommandInterface>>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public void recreate() {
		myTrails.get(0).recreate();
		myTurtles.get(0).getPen().recreate();
		myColor = Color.web(myColorHex);
	}

	public void writeObject(ObjectOutputStream o) throws IOException {
		o.defaultWriteObject();
	}

	public void readObject(ObjectInputStream i) throws ClassNotFoundException, IOException {
		i.defaultReadObject();
	}

	@Override
	public int turtleListSize() {

		return myTurtles.size();
	}

	public static void setActiveTurtle(int value) {
		activeTurtle = value;
	}

	@Override
	public int getActiveTurtleID() {

		return activeTurtle + 1;

	}

	public Map<String, List<String>> getMyCommandVariableMap() {
		return myCommandVariableMap;
	}

	public void setMyCommandVariableMap(Map<String, List<String>> myCommandVariableMap) {
		this.myCommandVariableMap = myCommandVariableMap;
	}

	@Override
	public TurtleCommandsObserver getTurtleCommandsObserver() {
		return turtleCommands;
	}
	@Override
	public DisplayCommandObserver getDisplayCommandsObserver(){
		return displayCommands;
	}

}
