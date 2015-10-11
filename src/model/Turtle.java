package model;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends SlogoObjects {
	private Group root;
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myTurtle = new ImageView(myImage);

	public Turtle(Group root) {
		super(root);
		this.root=root;
		myTurtle.setLayoutX(500);
		myTurtle.setLayoutY(500);
		root.getChildren().add(myTurtle);
	}




	@Override
	public ImageView getMyImage() {
		return myTurtle;
	}

}
