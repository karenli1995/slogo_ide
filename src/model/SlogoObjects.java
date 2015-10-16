package model;

public abstract class SlogoObjects {

	private Location myLocation;
	private double myHeadAngle;
	private boolean isShowing = true;
	

	public SlogoObjects() {

	}
	
	public void setLocation(Location loc) {
		myLocation = loc;
	}
	
	public Location getLocation() {
		return myLocation;
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
