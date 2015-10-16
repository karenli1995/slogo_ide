package view;

import java.util.ArrayList;
import java.util.List;
import model.Turtle;
import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtleScene extends TabPane {
	
	private List<Tab> myTabs;
	private ModelController myController;
	
	private double myCanvasWidth = SlogoProperties.getSceneWidth()*3/7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight()*5/7;

	public TurtleScene(ModelController controller) {
		myTabs = new ArrayList<Tab>();
		myController = controller;
		addNewTab();
	}
	
	public double getX(){
		return this.getTranslateX();
	}
	
	public double getY(){
		return this.getTranslateY();
	}
	
	public double getMyCanvasWidth(){
		return myCanvasWidth;
	}
	
	public double getMyCanvasHeight(){
		return myCanvasHeight;
	}
	
	private void addNewTab() {
 		Tab tab = new Tab();
 		tab.setText("New Tab");
 		Canvas canvas = new Canvas();
 		canvas.setWidth(myCanvasWidth);
 		canvas.setHeight(myCanvasHeight);
 		GraphicsContext gc = canvas.getGraphicsContext2D();
 		setColor(gc, canvas, Color.ALICEBLUE);
        
 		setTurtle();
 		tab.setContent(canvas);
 		
 		myTabs.add(tab);
 	
 		this.getTabs().add(tab);
 	}
 	
//	private void setTurtle(GraphicsContext gc) {
//		int defaultTurtId = 0;
//		Turtle currTurt = (Turtle) myController.getData().getTurtle(defaultTurtId);
//		SlogoImage currTurtView = new SlogoImage(myController, defaultTurtId);
//		Image currTurtImage = currTurtView.getImage();
//		gc.drawImage(currTurtImage, currTurt.getLocation().getX(), currTurt.getLocation().getX());
//	}
	
	private void setTurtle() {
		int defaultTurtId = 0;
		Turtle currTurt = (Turtle) myController.getData().getTurtle(defaultTurtId);
		double currTurtLocX = currTurt.getLocation().getX();
		double currTurtLocY = currTurt.getLocation().getY();
		
		SlogoImage currTurtView = new SlogoImage(this, myController, defaultTurtId);
		ImageView currTurtImage = currTurtView.getMyImage();
		currTurtView.setScreenLoc(currTurtLocX, currTurtLocY);
		
		this.getChildren().add(currTurtImage);
		
	}

	private void setColor(GraphicsContext gc, Canvas canvas, Color color) {
		gc.setFill(color);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
	}

}
