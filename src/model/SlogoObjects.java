package model;

import java.util.Observable;

public abstract class SlogoObjects extends Observable {

	private Location myLocation;
	private boolean isShowing = true;
	private double myRotationAngle;
	
	public SlogoObjects() {

	}

	/**
	 * Sets the next location of the turtle.
	 * @param loc
	 */
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

	public Trail getTrail(){
		return myTrail;
	}

	public void setTrail(Trail trail){
		myTrail = trail;
		setChanged();
		notifyObservers();
	}
}
