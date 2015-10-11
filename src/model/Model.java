package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Model {
	List<Turtle> myTurtles = new ArrayList<Turtle>();
	
	public Model(){
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
	}
	
	public Turtle getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}
	
	public void addTurtle(){
		myTurtles.add(new Turtle());
	}
	
	public Collection<Turtle> getAllTurtles() {
		return myTurtles;
	}
	
}
