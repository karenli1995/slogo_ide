package model;

import javafx.scene.image.ImageView;

public abstract class Object {
	private int myX;
	private int myY;
	private int myHeight;
	private int myWidth;

	public int getMyX() {
		return myX;
	}

	public void setMyX(int myX) {
		this.myX = myX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int myY) {
		this.myY = myY;
	}

	public int getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public int getMyWidth() {
		return myWidth;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	public abstract ImageView getmyImage();

	public void setRotation(int angle) {
		this.getmyImage().setRotate(angle);
	}

	public void showSlogoObject() {
		this.getmyImage().setVisible(true);
	}

	public void hideSlogoObject() {
		this.getmyImage().setVisible(false);
	}

}
