/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Point2D;

/**
 *
 * @author Sally Al
 *
 */
public class Trail extends Observable{	

	private AbstractPen myPen; //defines visual aspects of path
	private Location myPrevLoc;
	private Location myNextLoc;
	public List<Point2D> myPath;
	private Data myModel; 

//	private static ArrayList<Observer> observerList;
	
	public Trail(AbstractPen pen) {
		myPen = pen;
		myPath = new ArrayList<Point2D>();
	}
	
	public double getPrevLocX(){
		return myPrevLoc.getX();
	}
	
	public double getPrevLocY(){
		return myPrevLoc.getY();
	}
	
	public double getNexLocX(){
		return myNextLoc.getX();
	}
	
	public double getNextLocY(){
		return myNextLoc.getY();
	}
	
	public void setNextLocX(double x){
		myNextLoc.setX(x);
		setChanged();
		notifyObservers();
	}
	
	public void setNextLocY(double y){
		myNextLoc.setY(y);
		setChanged();
		notifyObservers();
	}
	
//	public List<Point2D> getPathCoordinates() {
//		return myPath;
//	}
	
//	public void notifyObservers() {
//		myModel.notifyObservers("trail");
//	}

	public void addModelObserver(Data model) {
		myModel = model;
	}

	public void addCoord(Point2D current) {
		myPath.add(current);
		
		System.out.println("Current trail");
		for(int i = 0; i < myPath.size(); i++){
			System.out.println("Point "+i+" = "+myPath.get(i).toString());
		}
		
	}

}
