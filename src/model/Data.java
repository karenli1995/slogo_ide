package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import command.CommandInterface;
import command.TurtleCommands;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Data implements Observer, Data_Turtle_Interface, ForObserverInterface, ColorData, Serializable {

	private static final long serialVersionUID = 2437173979976418913L;
	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails;
	private boolean myError;
	private String myErrorMessage;
	private List<String> myUserHistory;
	private Map<String, Double> myVariableMap;
	private Map<String, ParseTreeNode<CommandInterface>> myUserCommandMap;
	private transient Color myColor;
	private String myColorHex;
	private double myCommandValue;


	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		myTrails = new ArrayList<Trail>();

		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		setTurtle(0, defaultTurtle); // check
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

	@Override
	public void setTurtle(int turtleId, SlogoObjects turtle) {
		myTurtles.set(turtleId, turtle);

	}

	@Override
	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	@Override

	public List<SlogoObjects> getAllTurtles(){
		return myTurtles;
	}

	public Trail getTrail(int turtleId) {
		return myTrails.get(turtleId);
	}

	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		this.myError = error;
		// setChanged();
		// notifyObservers();
	}

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		this.myUserHistory = userHistory;
		// setChanged();
		// notifyObservers();
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
		// setChanged();
		// notifyObservers();
	}

	public void setVariableMap(Map<String, Double> variableMap) {
		this.myVariableMap = variableMap;
	}

	@Override
	public void updateVaraibleMap(String varName, Double value) {
		myVariableMap.put(varName, value);
		// setChanged();
		// notifyObservers();
	}

	public void setUserCommandMap(Map<String, ParseTreeNode<CommandInterface>> userCommandMap) {
		this.myUserCommandMap = userCommandMap;

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
		this.myCommandValue = commandValue;
	}

	@Override
	public String getErrorMessage() {
		String temp = myErrorMessage;
		myErrorMessage=null;
		return temp;
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		this.myErrorMessage = errorMessage;

	}

	@Override
	public Map<String, Double> getVariableMap() {
		return myVariableMap;
	}

	@Override
	public Map<String, ParseTreeNode<CommandInterface>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public void recreate(){
		myTrails.get(0).recreate();
		myTurtles.get(0).getPen().recreate();
		myColor = Color.web(myColorHex);
	}

	public void writeObject(ObjectOutputStream o) throws IOException{
		o.defaultWriteObject();
	}

	public void readObject(ObjectInputStream i) throws ClassNotFoundException, IOException{
		i.defaultReadObject();
	}


	@Override
	public void update(Observable o, Object arg) {
		TurtleCommands observedClass = (TurtleCommands) o;
		Point2D NewCoordinate = new Point2D(observedClass.getCoordinates().get("XCor"),
				observedClass.getCoordinates().get("YCor"));
		//this.getTurtle(0).setTrail(new Trail(NewCoordinate, 0));

		this.getTurtle(0).getTrail().addCoord(NewCoordinate, this.getTurtle(0).getPen().isDown(), this.getTurtle(0).getPen().getColor().toString(),
				this.getTurtle(0).getPen().getThickness());
		this.getTurtle(0).setTrail(this.getTurtle(0).getTrail());
		this.getTurtle(0).getTrail().setPoint(NewCoordinate);
		this.getTurtle(0).setRotationAngle(observedClass.getCoordinates().get("Angle"));
		this.setTurtle(0, this.getTurtle(0));



	}

}
