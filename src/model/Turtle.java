package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Object {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);

	@Override
	public ImageView getmyImage() {
		return myTurtle;
	}

}
