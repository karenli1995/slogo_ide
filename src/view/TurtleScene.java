package view;

import java.util.List;

import controller.ViewController;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Turtle;

public class TurtleScene extends TabPane {

	private ViewController myViewController;
	
	private List<Tab> myTabs;

	private double myCanvasWidth;
	private double myCanvasHeight;

	public TurtleScene(double width, double height) {
		myCanvasWidth = width;
		myCanvasHeight = height;
		addNewTab();

		//myTurtle = myViewController.getDefaultTurtle();
		//		setInitTurtPos(myTurtle);
	}
	
	private void addNewTab() {
 		Tab tab = new Tab();
 		tab.setText("New Tab");
 		Rectangle rect = new Rectangle();
 		rect.setWidth(myCanvasWidth);
 		rect.setHeight(myCanvasHeight);
 		setColor(rect, Color.ALICEBLUE);
 		tab.setContent(rect);
 		
 		myTabs.add(tab);
 	
 		this.getTabs().add(tab);
 	}
 	

	private void setColor(Rectangle rect, Color color) {
		rect.setFill(color);
	}

//	public  int getCentrex() {
//		return centreX;
//	}
//
//	public  int getCentrey() {
//		return centreY;
//	}

}
