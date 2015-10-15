package view;

import controller.ViewController;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import model.Turtle;

public class TurtleScene extends Rectangle {

	private ViewController myViewController;

	private Turtle myTurtle;

	private static double myCanvasWidth = (Screen.getPrimary().getVisualBounds().getWidth())*3/7;
	private static double myCanvasHeight = (Screen.getPrimary().getVisualBounds().getHeight())*4/5;	
	private static final double myCanvasXPosition = 360/548.5714285714286*myCanvasWidth; //empirically found
	private static final int centreX = (int)((myCanvasWidth / 2) + myCanvasXPosition-20);//subtracted value should be half width of turtle
	private static final int centreY = (int)((myCanvasHeight / 2)-20); //subtracted value should be half the height of the turtle

	public TurtleScene() {
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor(Color.ANTIQUEWHITE);
		System.out.println(myCanvasWidth);
		System.out.println(centreY);


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
