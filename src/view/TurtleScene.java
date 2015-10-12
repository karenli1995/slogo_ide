package view;

import controller.ViewController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Turtle;

public class TurtleScene extends Rectangle{

	private ViewController myViewController;
	
	private Turtle myTurtle;

	private int myCanvasWidth = 900;
	private int myCanvasHeight = 900;

	TurtleScene(){
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor(Color.ANTIQUEWHITE);

		//myTurtle = myViewController.getDefaultTurtle();
		//		setInitTurtPos(myTurtle);
	}

	private void setColor(Color color){
		this.setFill(color);
	}

	private void setInitTurtPos(Turtle turt){

	}

}
