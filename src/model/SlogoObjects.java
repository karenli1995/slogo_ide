package model;

import java.util.Observable;

import javafx.geometry.Point2D;

public abstract class SlogoObjects extends Observable {

	private Trail myTrail;
	private AbstractPen myPen;
	private boolean isShowing = true;
	private double myRotationAngle;
	private boolean clearTrails = false;

	public SlogoObjects() {
		Point2D startPoint = new Point2D(0, 0);
		myTrail = new Trail(startPoint, 0);
		myPen = new Pen();
	}

	public void setTrail(Trail loc) {
		myTrail = loc;
		setChanged();
		notifyObservers();
	}

	public Trail getTrail() {
		return myTrail;
	}

	public boolean getClearTrail() {
		return clearTrails;
	}

	public void setClearTrail(boolean b){
		clearTrails = b;
		this.getTrail().getPathCoordinates().clear();
		setChanged();
		notifyObservers();
	}

	public Pen getPen() {
		return (Pen) myPen;
	}

	public void setPen(Pen pen){
		myPen = pen;
		setChanged();
		notifyObservers();
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
