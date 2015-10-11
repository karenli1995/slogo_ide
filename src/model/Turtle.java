package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Object {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);
	
	private Location myLoc;
	
	Turtle(Location loc){
		myLoc = loc;
		ImageView turtleImage = getMyImage();
		ImageView turtle = setTurtLoc(turtleImage);
	}
	
	private ImageView setTurtLoc(ImageView image) {
		image.setLayoutX(myLoc.getX());
		image.setLayoutY(myLoc.getY());
		return image;
	}

//	public int getLocX(){
//		return myLoc.getX();
//	}
//	
//	public int getLocY(){
//		return myLoc.getY();
//	}

	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
