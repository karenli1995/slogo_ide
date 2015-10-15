package model;

import javafx.geometry.Point2D;

public class Location {
	private Point2D myPoint;
	private double myDirection;
	
	private static final int CIRCLE = 360;
	private static final int NORTH = 90;
	private static final int SOUTH = 270;
	private static final int EAST = 0;
	private static final int WEST = 180;
	
	public Location(Location oldBearing) {
		this(oldBearing.getPoint(), oldBearing.getDirection());
	}

	public Location(Point2D point, double direction) {
		myPoint = point;
		myDirection = direction;
	}

	public Location() {
		this(new Point2D(0,0), NORTH);
	}
	
	public void setX(double x) {
		myPoint.add(x, myPoint.getY());
	}

	public void setY(double y) {
		myPoint.add(myPoint.getX(), y);
	}

	public void setPoint(Point2D point) {
		myPoint = point;
	}

	public Point2D getPoint() {
		return myPoint;
	}

	public void setDirection(double direction) {
		myDirection = direction;
	}

	public double getX() {
		return myPoint.getX();
	}

	public double getY() {
		return myPoint.getY();
	}

	public double getDirection() {
		return myDirection;
	}

}
