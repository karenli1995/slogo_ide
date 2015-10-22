package model;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class Trail {
	private Point2D myPoint;
	private List<Point2D> myPath = new ArrayList<Point2D>();
	private double myDirection;

	public Trail(Trail oldBearing) {
		this(oldBearing.getPoint(), oldBearing.getDirection());
	}

	public Trail(Point2D point, double direction) {
		myPath.add(point);
		myPath.add(point); //check
		myPoint = point;
		myDirection = direction;
	}

	public Trail() {
		this(new Point2D(0, 0), 0);
	}

	public List<Point2D> getPathCoordinates() {
		return myPath;
	}

	public double getX() {
		return myPoint.getX();
	}

	public double getY() {
		return myPoint.getY();
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

	public double getDirection() {
		return myDirection;
	}

	public void addCoord(Point2D current) {
		myPath.add(current);



	}
}
