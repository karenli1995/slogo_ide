package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends SlogoObjects {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);

	public Turtle() {

		myTurtle.setLayoutX(500);
		myTurtle.setLayoutY(500);
	}

	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
