package model;

import java.util.Observable;

import javafx.geometry.Point2D;

public abstract class SlogoObjects{

	private Trail myTrail;
//	private SlogoScene mySlogoScene;
	private AbstractPen myPen;
	private boolean isShowing = true;
	private double myRotationAngle;
	private boolean clearTrails = false;

	public SlogoObjects() {
		Point2D startPoint = new Point2D(0, 0);
		myTrail = new Trail(startPoint, 0);
		myPen = new Pen();
//		mySlogoScene = new SlogoScene();
	}

	public void setTrail(Trail loc) {
		myTrail = loc;
		setChanged();
		notifyObservers();
	}

	public Trail getTrail() {
		return myTrail;
	}
	
//	public void setMyScene(SlogoScene scene){
//		mySlogoScene = scene;
//		setChanged();
//		notifyObservers();
//	}
//	
//	public SlogoScene getMyScene(){
//		return mySlogoScene;
//	}

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
