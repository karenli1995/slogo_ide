package model;

import javafx.geometry.Point2D;

public abstract class SlogoObjects{

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

	public void setPen(Pen pen){
		myPen = pen;
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
}
