package model;

import java.util.Observable;

public abstract class SlogoObjects extends Observable {

	private Trail myLocation;
	private boolean isShowing = true;
	private double myRotationAngle;
	
	public SlogoObjects() {

	}

	/**
	 * Sets the next location of the turtle.
	 * @param loc
	 */
	public void setLocation(Trail loc) {
		myLocation = loc;
		setChanged();
		notifyObservers();
	}

	public Trail getLocation() {
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
}
