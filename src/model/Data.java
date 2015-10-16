package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.shape.Line;

public class Data implements Observer{
	
	private List<SlogoObjects> myTurtles;
	private List<Trail> myTrails = new ArrayList<Trail>();

//	private int pen = 0;
	
	public Data() {
		myTurtles = new ArrayList<SlogoObjects>();
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
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


	@Override
	public void update(Observable o, Object arg) {
		for (SlogoObjects slogoObj : myTurtles){
			slogoObj.addObserver(this);
			if (slogoObj == o) {
				System.out.println("karen " );
			} else {
				System.out.println("jenny ");
			}
		}
		
	}

}
