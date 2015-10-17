package model;

import javafx.geometry.Point2D;

public class Turtle extends SlogoObjects{
		
	public Turtle() {
		setLocation(new Trail( new Point2D(0,0), 270 ));
	}
}
