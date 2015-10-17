package model;

import java.util.List;

import javafx.geometry.Point2D;

public class Location {
	private AbstractPen myPen;
	private Point2D myPoint;
	private List<Point2D> myPath;
	private double myDirection;
	
	public Location(Location oldBearing) {
		this(oldBearing.getPoint(), oldBearing.getDirection());
	}

	public Location(Point2D point, double direction) {
		myPen = new Pen();
		myPoint = point;
		myDirection = direction;
	}

	public Location() {
		this(new Point2D(0,0), 0);
	}
	
	public Pen getPen(){
		return (Pen) myPen;
	}
	
	public List<Point2D> getPathCoordinates(){
		return myPath;
	}
	
	public void setX(double x) {
		myPoint.add(x, myPoint.getY());
	}

	public void setY(double y) {
		myPoint.add(myPoint.getX(), y);
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
		
		System.out.println("Current trail");
		for(int i = 0; i < myPath.size(); i++){
			System.out.println("Point "+i+" = "+myPath.get(i).toString());
		}
		
	}
}
