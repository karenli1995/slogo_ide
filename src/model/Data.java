package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.shape.Line;

public class Data{
	
	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails = new ArrayList<Trail>();
	private boolean error = false;
	private String errorMessage;
	private List<String> userHistory;
//	private int pen = 0;
	
	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		setUserHistory(new ArrayList<String>());
	}
	

//	public void setPen(int option) {
//		pen = option;
//	}
//
//	public int getPen() {
//		return pen;
//	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	/*
	 * public void addTurtle() { myTurtles.add(new Turtle()); }
	 */

	public List<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	Line myLine = new Line();

	public Line getLine() {
		return myLine;
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
	
	public void addCommandToHistory(String s){
		userHistory.add(s);
	}


//	@Override
//	public void update(Observable o, Object arg) {
//		for (SlogoObjects slogoObj : myTurtles){
//			slogoObj.addObserver(this);
//			if (slogoObj == o) {
//				System.out.println("karen " );
//			} else {
//				System.out.println("jenny ");
//			}
//		}
//		
//	}

}
