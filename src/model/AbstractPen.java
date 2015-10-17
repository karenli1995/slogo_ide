package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public abstract class AbstractPen {

	protected Color myColor;

	protected int myThickness;

	protected int myDashSparsity;

	protected Trail myTrail;
	
	protected boolean myStatus;

	public AbstractPen(Color color, int thickness, int dashSparsity, boolean bool) {
		myStatus = bool;
		myColor = color;
		myThickness = thickness;
		myDashSparsity = dashSparsity;
		myTrail = new Trail();
	}

	public Trail getTrail() {
		return myTrail;
	}
	
	public int getThickness() {
		return myThickness;
	}

	public void setThickness(int myThickness) {
		this.myThickness = myThickness;
	}
	
	public void setColor(Color color){
		myColor = color;
	}
	
	public Color getColor(){
		return myColor;
	}

	public void updateTrail(Point2D current) {
		myTrail.addCoord(current);
	}
	
	public void setPen(boolean bool){
		myStatus = bool;
	}
	
	public boolean isUp(){
		return myStatus;
	}

}
