package model;

import javafx.scene.image.ImageView;

public abstract class SlogoObjects {

	private double myHeadAngle;
	private int isShowing = 1;

	public SlogoObjects() {

	}

	public void setIsShowing(int value) {
		isShowing = value;
	}

	public int getIsShowing() {
		return isShowing;
	}

	public double getMyHeadAngle() {
		return myHeadAngle;
	}

	public void setMyHeadAngle(double myHeadAngle) {
		this.myHeadAngle = myHeadAngle;
	}

	public void setRotation(int angle) {
		this.getMyImage().setRotate(angle);
	}

	public abstract ImageView getMyImage();

	public void showSlogoObject() {
		this.getMyImage().setVisible(true);
	}

	public void hideSlogoObject() {
		this.getMyImage().setVisible(false);
	}

}
