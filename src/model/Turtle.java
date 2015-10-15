package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends SlogoObjects {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);

	public Turtle() {
		myTurtle.setFitWidth(40);
		myTurtle.setFitHeight(40);
	}

	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
