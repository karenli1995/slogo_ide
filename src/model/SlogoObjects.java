package model;

import java.util.Observable;

public abstract class SlogoObjects extends Observable {

	private Location myLocation;
	private double myHeadAngle;
	private boolean isShowing = true;
	private double myRotationAngle;

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

	public double getMyHeadAngle() {
		return myHeadAngle;
	}

	public void setMyHeadAngle(double headAngle) {
		myHeadAngle = headAngle;
	}

	public void setRotationAngle(Double angle) {
		myRotationAngle = angle;
	}

	public double getRotationAngle() {
		return myRotationAngle;
	}
}
