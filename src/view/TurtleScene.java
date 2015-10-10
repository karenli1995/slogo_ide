package view;

import data.Data;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurtleScene extends Rectangle{
	
	private int myCanvasWidth = 800;
	private int myCanvasHeight = 900;
	
	TurtleScene(){
		this.setWidth(myCanvasWidth);
		this.setHeight(myCanvasHeight);
		setColor();
	}
	
	private void setColor(){
		this.setFill(Color.WHITE);
	}
	
}
