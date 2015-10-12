package view;

import controller.ViewController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Turtle;

public class TurtleScene extends Rectangle {

	private ViewController myViewController;

	private Turtle myTurtle;

	private static final int myCanvasWidth = 900;
	private static final int myCanvasHeight = 900;
	private static final int myCanvasXPosition = 200;
	private static final int myCanvasYPosition = 200;
	private static final int centreX = (myCanvasWidth / 2) + myCanvasXPosition;
	private static final int centreY = (myCanvasHeight / 2) + myCanvasYPosition;

	public TurtleScene() {
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor(Color.ANTIQUEWHITE);

		// myTurtle = myViewController.getDefaultTurtle();
		// setInitTurtPos(myTurtle);
	}

	private void setColor(Color color) {
		this.setFill(color);
	}

	public  int getCentrex() {
		return centreX;
	}

	public  int getCentrey() {
		return centreY;
	}

}
