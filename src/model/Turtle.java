package model;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.TurtleScene;

public class Turtle extends SlogoObjects {
	private static TurtleScene turtleScene = new TurtleScene();
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);

	public Turtle() {
		myTurtle.setFitWidth(40);
		myTurtle.setFitHeight(40);
		myTurtle.setLayoutX(turtleScene.getCentrex());
		myTurtle.setLayoutY(turtleScene.getCentrey());

	}

	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
