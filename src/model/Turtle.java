package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Object {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);
	
	private Location myLoc;
	
	Turtle(){
		myLoc = new Location();
		getMyImage();
	}

	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
