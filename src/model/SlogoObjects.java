package model;

import java.util.Observable;

public abstract class SlogoObjects extends Observable {

	private Trail myTrail;
	private boolean isShowing = true;
	private double myRotationAngle;
	
	public SlogoObjects() {

	}

	/**
	 * Sets the next location of the turtle.
	 * @param loc
	 */
	public void setTrail(Trail loc) {
		myTrail = loc;
		setChanged();
		notifyObservers();
	}

	public Trail getTrail() {
		return myTrail;
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
