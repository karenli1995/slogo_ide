package model;

import java.util.Observable;

public class MathCommand extends Observable{
	
	private double myValue;
	
	public MathCommand(){
		this.setMathValue(0);
	}
	
	public double getMathValue(){
		return myValue;
	}
	
	public void setMathValue(double value) {
		myValue = value;
		setChanged();
		notifyObservers();
	}

}
