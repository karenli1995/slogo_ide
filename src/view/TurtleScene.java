package view;

import model.Turtle;
import controller.ViewController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurtleScene extends Rectangle{
	
	private ViewController myViewController;
		
	private int myCanvasWidth = 900;
	private int myCanvasHeight = 900;
	
	TurtleScene(ViewController viewController){
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor(Color.ANTIQUEWHITE);
		
		myViewController = viewController;
	}
	
	private void setColor(Color color){
		this.setFill(color);
	}
	
	private void setInitTurtPos(){
		myViewController.getDefaultTurtle();
	}
	
}
