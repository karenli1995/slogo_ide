/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Point2D;

/**
 *
 * @author Sally Al
 *
 */
public class Trail extends Observable{	

	public AbstractPen myPen; //defines visual aspects of path
	public ArrayList<Point2D> myPath;
	private Data myModel; 

	private static ArrayList<Observer> observerList;
	
	public Trail(AbstractPen pen) {
		myPen = pen;
		myPath = new ArrayList<Point2D>();
	}
	
	public Collection<Point2D> getPathCoordinates() {
		return myPath;
	}
	
	/*public void notifyObservers() {
		myModel.notifyObservers("trail");
	}*/

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
