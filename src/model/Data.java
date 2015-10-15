package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Data {

	private List<SlogoObjects> myTurtles = new ArrayList<SlogoObjects>();

	private int pen = 0;
	
	public Data() {
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
	}
	

	public void setPen(int option) {
		pen = option;
	}

	public int getPen() {
		return pen;
	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	/*
	 * public void addTurtle() { myTurtles.add(new Turtle()); }
	 */

	public Collection<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	Line myLine = new Line();

	public Line getLine() {
		return myLine;
	}
}
