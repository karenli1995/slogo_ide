package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Model {
	List<Turtle> myTurtles = new ArrayList<Turtle>();
	
	public Model(){
		Turtle defaultTurtle = new Turtle(new Location());
		myTurtles.add(defaultTurtle);
	}
	
//	public Turtle getDefaultTurtle(){
//		
//	}
	
	public Turtle getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}
	
	public void addTurtle(Location loc){
		myTurtles.add(new Turtle(loc));
	}
	
	public Collection<Turtle> getAllTurtles() {
		return myTurtles;
	}
	
}
