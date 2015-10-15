package view;

import controller.ViewController;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Turtle;

public class TurtleScene extends Rectangle {

	private ViewController myViewController;

	private Turtle myTurtle;

	private static double myCanvasWidth = SlogoProperties.SCENE_WIDTH*3/7;
	private static double myCanvasHeight = SlogoProperties.SCENE_HEIGHT*9/20;
	private static final int myCanvasXPosition = 350;
	private static final int myCanvasYPosition = 0;
	private static final int centreX = (int)((myCanvasWidth / 2) + myCanvasXPosition);
	private static final int centreY = (int)((myCanvasHeight / 2) + myCanvasYPosition);

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
