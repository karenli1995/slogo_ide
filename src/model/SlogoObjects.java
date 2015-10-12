package model;

import javafx.scene.image.ImageView;

public abstract class SlogoObjects {
	private int myX;
	private int myY;
	private int myHeight;
	private int myWidth;


public SlogoObjects(){

}

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


	public void setRotation(int angle) {
		this.getMyImage().setRotate(angle);
	}

	private int getMyHeight() {
		return myHeight;
	}

	private void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	private int getMyWidth() {
		return myWidth;
	}

	private void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	public abstract ImageView getMyImage();


	public void showSlogoObject() {
		this.getMyImage().setVisible(true);
	}

	public void hideSlogoObject() {
		this.getMyImage().setVisible(false);
	}

}
