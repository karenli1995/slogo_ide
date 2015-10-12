package model;

import javafx.scene.image.ImageView;

public abstract class SlogoObjects {


	public SlogoObjects() {

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
