package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurtleScene extends Rectangle{
	
	private int myCanvasWidth = 900;
	private int myCanvasHeight = 900;
	
	TurtleScene(){
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor(Color.ANTIQUEWHITE);
	}
	
	private void setColor(Color color){
		this.setFill(color);
	}
	
}
