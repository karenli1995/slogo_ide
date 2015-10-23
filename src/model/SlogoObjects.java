package model;

import javafx.geometry.Point2D;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class SlogoObjects implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2429059406459972387L;
	private Trail myTrail;
	private AbstractPen myPen;
	private boolean isShowing;
	private double myRotationAngle;
	private boolean clearTrails;
	private boolean isActive;

	public SlogoObjects(){
		Point2D startPoint = new Point2D(0, 0);
		setTrail(new Trail(startPoint, 0));
		setPen(new Pen());
		
		setIsShowing(true);
		setClearTrail(false);
		setIsActive(false);
	}

	public void setTrail(Trail loc) {
		myTrail = loc;
	}

	public Trail getTrail() {
		return myTrail;
	}

	public boolean getClearTrail() {
		return clearTrails;
	}

	public void setClearTrail(boolean b){
		clearTrails = b;
//		setChanged();
//		notifyObservers();
	}

	public Pen getPen() {
		return (Pen) myPen;
	}

	public void setPen(AbstractPen myPen2){
		myPen = myPen2;
	}

	public void setIsShowing(boolean value) {
		isShowing = value;
	}

	public boolean getIsShowing() {
		return isShowing;
	}

	public void setRotationAngle(Double angle) {
		myRotationAngle = angle;
	}

	public double getRotationAngle() {
		return myRotationAngle;
	}
	
	public void setIsActive(boolean b){
		isActive = b;
	}
	
	public boolean getIsActive(){
		return isActive;
	}
	
	/*public void writeObject(ObjectOutputStream o) throws IOException{
		o.defaultWriteObject();
	}
	
	public void readObject(ObjectInputStream i) throws ClassNotFoundException, IOException{
		i.defaultReadObject();
	}*/
}
