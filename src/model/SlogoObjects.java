package model;

public abstract class SlogoObjects {

	private double myHeadAngle;
	private boolean isShowing = true;
	

	public SlogoObjects() {

	}

	public void setIsShowing(boolean value) {
		isShowing = value;
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
}
