package model;

import javafx.geometry.Point2D;

public class Turtle extends SlogoObjects {
	
	private Location myLocation;
	
	public Turtle() {
		setLocation(new Location( new Point2D(20,30), 270 ));
	}
	
	public void setLocation(Location loc) {
		myLocation = loc;
	}
	
	public Location getLocation() {
		return myLocation;
	}

}
