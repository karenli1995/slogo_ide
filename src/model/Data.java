package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.shape.Line;

public class Data{
	
	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails = new ArrayList<Trail>();
	
	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		defaultTurtle.getPen().getTrail().addCoord(defaultTurtle.getLocation().getPoint());
		myTrails.add(defaultTurtle.getPen().getTrail());
	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	/*
	 * public void addTurtle() { 
	 * tempTurt = new Turtle();
	 * myTurtles.add(tempTurt);
	 * tempTurtle.getPen().getTrail().addCoord(tempTurtle.getLocation().getPoint());
		myTrails.add(tempTurtle.getPen().getTrail());
	 * 
	 * 
	 * }
	 */

	public List<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	Line myLine = new Line();

	public Line getLine() {
		return myLine;
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
