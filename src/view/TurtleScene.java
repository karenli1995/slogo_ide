package view;

import java.util.ArrayList;
import java.util.List;

import model.Turtle;
import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurtleScene extends TabPane {
	
	private List<Tab> myTabs;
	private ModelController myController;
	
	private double myCanvasWidth = SlogoProperties.getSceneWidth()*3/7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight()*5/7;

	public TurtleScene(ModelController controller) {
		myTabs = new ArrayList<Tab>();
		myController = controller;
		addNewTab();
		//myTurtle = myViewController.getDefaultTurtle();
		//		setInitTurtPos(myTurtle);
	}
	
	private void addNewTab() {
 		Tab tab = new Tab();
 		tab.setText("New Tab");
 		Canvas canvas = new Canvas();
 		canvas.setWidth(myCanvasWidth);
 		canvas.setHeight(myCanvasHeight);
 		GraphicsContext gc = canvas.getGraphicsContext2D();
 		setColor(gc, canvas, Color.ALICEBLUE);
        
 		//setTurtle(canvas);
 		tab.setContent(canvas);
 		
 		myTabs.add(tab);
 	
 		this.getTabs().add(tab);
 	}
 	
	private void setTurtle(GraphicsContext gc) {
//		myController.getData();
		ImageView currTurt = myController.getData().getTurtle(0).getMyImage();
		//gc.drawImage(currTurt,0,0);
	}

	private void setColor(GraphicsContext gc, Canvas canvas, Color color) {
		gc.setFill(color);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
	}

//	public  int getCentrex() {
//		return centreX;
//	}
//
//	public  int getCentrey() {
//		return centreY;
//	}

}
