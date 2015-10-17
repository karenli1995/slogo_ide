package model;

import java.util.Observable;

public abstract class SlogoObjects extends Observable {

	private Location myLocation;
	private boolean isShowing = true;
	private double myRotationAngle;

	private Pen myPen = new Pen();
	
	public SlogoObjects() {

	}

	public void setLocation(Location loc) {
		myLocation = loc;
		setChanged();
		notifyObservers();
	}

	public Location getLocation() {
		return myLocation;
	}

	public void setIsShowing(boolean value) {
		isShowing = value;
		setChanged();
		notifyObservers();
	}

	public boolean getIsShowing() {
		return isShowing;
	}

	public void setRotationAngle(Double angle) {
		myRotationAngle = angle;
		setChanged();
		notifyObservers();
	}

	public double getRotationAngle() {
		return myRotationAngle;
	}

	public Pen getPen(){
		return myPen;
	}
	
	public void setPen(Pen pen){
		myPen = pen;
		setChanged();
		notifyObservers();
	}
}
