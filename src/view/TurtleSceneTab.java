package view;

import controller.ModelController;
import model.Turtle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtleSceneTab extends Tab{
	private ImageView myImage;
	private Canvas myCanvas;
	private ModelController myModelController;
	
	private double myCanvasWidth = SlogoProperties.getSceneWidth()*3/7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight()*5/7;
	
	TurtleSceneTab(TurtleScene turtScene, ModelController controller){
		myModelController = controller;
		
		this.setText("New Text");
		myCanvas = new Canvas();
		
		myCanvas.setWidth(myCanvasWidth);
		myCanvas.setHeight(myCanvasHeight);
 		GraphicsContext gc = myCanvas.getGraphicsContext2D();
 		setColor(gc, myCanvas, Color.ALICEBLUE);
        
 		turtScene.getTabs().add(this);
 		
 		int defaultTurt = 0;
 		setTurtle(0, turtScene);
 		this.setContent(myCanvas);
	}

	
	public void setTurtle(int id, TurtleScene turtScene) {
		Turtle currTurt = (Turtle) myModelController.getData().getTurtle(id);
		double currTurtLocX = currTurt.getLocation().getX();
		double currTurtLocY = currTurt.getLocation().getY();
		
		SlogoImage currTurtView = new SlogoImage(turtScene, myModelController, id);
		myImage = currTurtView.getMyImage();
		currTurtView.setScreenLoc(currTurtLocX, currTurtLocY);
	}
	
	public ImageView getTurtImage(){
		return myImage;
	}
	
	public double getMyCanvasWidth(){
		return myCanvasWidth;
	}
	
	public double getMyCanvasHeight(){
		return myCanvasHeight;
	}
	
	public void setColor(GraphicsContext gc, Canvas canvas, Color color) {
		gc.setFill(color);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
	}
}
