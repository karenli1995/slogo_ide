package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Data {
	private Group root;
	
	private List<SlogoObjects> myTurtles = new ArrayList<SlogoObjects>();
	private List<Trail> myTrails = new ArrayList<Trail>();

//	private int pen = 0;
	
	public Data() {
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
//		root.getChildren().add(this.getData().getTurtle(0).getMyImage());
		System.out.println(myTurtles.size());
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
}
