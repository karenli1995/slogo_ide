package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.scene.Group;

public class Data {

	List<SlogoObjects> myTurtles = new ArrayList<SlogoObjects>();

	public Data(Group root) {
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	/*public void addTurtle() {
		myTurtles.add(new Turtle());
	}*/

	public Collection<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}
}
