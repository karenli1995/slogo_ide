package model;

import java.io.Serializable;

import javafx.scene.paint.Color;

public abstract class AbstractPen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3942383150109943668L;

	protected transient Color myColor;
	
	protected String mySColor;

	protected int myThickness;

	protected int myDashSparsity;

	protected Double myStatus;

	// pen down =1.0 , pen up =0.0
	public AbstractPen(Color color, int thickness, int dashSparsity, Double bool) {
		myStatus = bool;
		myColor = color;
		mySColor = color.toString();
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
		mySColor = color.toString();
	}
	
	public void recreate(){
		System.out.println(mySColor);
		myColor = Color.web(mySColor);
	}

	public Color getColor() {
		return myColor;
	}

	public void setPenDown(Double bool) {
		myStatus = bool;
	}

	public Double isDown() {
		return myStatus;
	}

}
