package model;

import javafx.scene.paint.Color;

public abstract class AbstractPen {

	protected Color myColor;

	protected int myThickness;

	protected int myDashSparsity;

	protected Double myStatus;

	// pen down =1.0 , pen up =0.0
	public AbstractPen(Color color, int thickness, int dashSparsity, Double bool) {
		myStatus = bool;
		myColor = color;
		myThickness = thickness;
		myDashSparsity = dashSparsity;
	}

	public int getThickness() {
		return myThickness;
	}

	public void setThickness(int myThickness) {
		this.myThickness = myThickness;
	}

	public void setColor(Color color) {
		myColor = color;
	}

	public Color getColor() {
		return myColor;
	}

	public void setPen(Double bool) {
		myStatus = bool;
	}

	public Double isDown() {
		return myStatus;
	}

}
