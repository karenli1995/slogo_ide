package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public abstract class AbstractPen {

	protected Color myColor;

	protected int myThickness;

	protected int myDashSparsity;

//	protected Trail myTrail;

	public AbstractPen(Color color, int thickness, int dashSparsity) {
		myColor = color;
		myThickness = thickness;
		myDashSparsity = dashSparsity;
//		myTrail = new Trail(this);
	}

//	public Trail getTrail() {
//		return myTrail;
//	}
	
	public int getThickness() {
		return myThickness;
	}

	public void setThickness(int myThickness) {
		this.myThickness = myThickness;
	}

//	public void updateTrail(Point2D current) {
//		myTrail.addCoord(current);
//	}

}
