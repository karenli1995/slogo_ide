package model;

import javafx.geometry.Point2D;

public class Turtle extends SlogoObjects{

	public Turtle() {
		Point2D startPoint = new Point2D(0,0);
		setTrail(new Trail( startPoint, 270 ));
		this.getTrail().addCoord(startPoint);
	}
}
