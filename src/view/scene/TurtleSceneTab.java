package view.scene;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.Data;
import model.SlogoScene;
import model.Turtle;
import view.settings.SlogoProperties;
import view.shapes.AbstractShape;
import view.shapes.StraightLine;
import view.turtles.SlogoImage;

public class TurtleSceneTab extends Tab{
	private SlogoImage mySlogoImage;
	private AbstractShape myShape; // check this
	private Canvas myCanvas;
	private ModelController myModelController;
	private TurtleScene myTurtScene;
//	private int myTabId;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleSceneTab(TurtleScene turtScene, ModelController controller) {
		myTurtScene = turtScene;
		myModelController = controller;
//		myTabId = id;
		this.setText("New Text");
		myCanvas = new Canvas();
		myCanvas.setWidth(myCanvasWidth);
		myCanvas.setHeight(myCanvasHeight);

		turtScene.addTab(this);
		turtScene.getTabs().add(this);

		int defaultTurt = 0;
		setTurtleAndTrail(defaultTurt, turtScene);
		myShape = new StraightLine(turtScene, myModelController);
		this.setContent(myCanvas);

	}
	
//	public int getTabId(){
//		return myTabId;
//	}

	public void setTurtleAndTrail(int id, TurtleScene turtScene) {
		int sceneId = turtScene.getIdOfTab();
		System.out.println(sceneId + " waterbottle");
		Turtle currTurt = (Turtle) myModelController.getMyScene().getData(sceneId).getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();

		mySlogoImage = new SlogoImage(turtScene, myModelController, id);
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);
	}

	public void setTurtImage(ImageView image, int id) {
		int sceneId = myTurtScene.getIdOfTab();
		Turtle currTurt = (Turtle) myModelController.getMyScene().getData(sceneId).getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		mySlogoImage.setMyImage(image);
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);
	}

//	public List<Object> getAllShapes() {
//		return myShape.getAllShapes();
//	}
	
	public Object getRecentShape(){
		int ind =  myShape.getAllShapes().size()-1;
		return myShape.getAllShapes().get(ind);
	}
	
	public AbstractShape getShape() {
		return myShape;
	}
//
//	public ImageView getTurtImage() {
//		return myImage;
//	}
	
	public Canvas getCanvas(){
		return myCanvas;
	}

	public double getMyCanvasWidth() {
		return myCanvasWidth;
	}

	public double getMyCanvasHeight() {
		return myCanvasHeight;
	}

	public void setBackgroundColor(GraphicsContext gc, Canvas canvas, Color color) {
		gc.setFill(color);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public SlogoImage getSlogoImage() {
		return mySlogoImage;
	}
	
}
