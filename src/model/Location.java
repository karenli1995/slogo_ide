package model;

import java.awt.Point;

public class Location {
	private Point myPoint;
	private double myDirection;
	
	private static final int CIRCLE = 360;
	private static final int NORTH = 90;
	private static final int SOUTH = 270;
	private static final int EAST = 0;
	private static final int WEST = 180;
	
	public Location(Location oldBearing) {
		this(oldBearing.getPoint(), oldBearing.getDirection());
	}

	public Location(Point point, double direction) {
		myPoint = new Point(point);
		myDirection = direction;
	}

	public Location() {
		this(new Point(), NORTH);
	}
	
	public void setX(int x) {
		myPoint.x = x;
	}

	public void setY(int y) {
		myPoint.y = y;
	}

	public void setPoint(Point point) {
		myPoint = new Point(point);
	}

	public Point getPoint() {
		return myPoint;
	}

	public void setDirection(double direction) {
		myDirection = direction;
	}

	public int getX() {
		return myPoint.x;
	}

	public int getY() {
		return myPoint.y;
	}

	public double getDirection() {
		return myDirection;
	}

}
