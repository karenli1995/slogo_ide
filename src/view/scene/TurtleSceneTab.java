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
import model.Turtle;
import view.settings.SlogoProperties;
import view.shapes.AbstractShape;
import view.shapes.StraightLine;
import view.turtles.SlogoImage;

public class TurtleSceneTab extends Tab implements Observer {
	private SlogoImage mySlogoImage;
	private AbstractShape myShape; // check this
	private ImageView myImage;
	private Canvas myCanvas;
	private ModelController myModelController;
	private TurtleScene myTurtScene;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleSceneTab(TurtleScene turtScene, ModelController controller) {
		myTurtScene = turtScene;
		myModelController = controller;
		this.setText("New Text");
		myCanvas = new Canvas();
		myCanvas.setWidth(myCanvasWidth);
		myCanvas.setHeight(myCanvasHeight);
//		GraphicsContext gc = myCanvas.getGraphicsContext2D();
//		setBackgroundColor(gc, myCanvas, Color.ALICEBLUE);

		turtScene.getTabs().add(this);

		int defaultTurt = 0;
		setTurtleAndTrail(defaultTurt, turtScene);
		this.setContent(myCanvas);

	}

	public void setTurtleAndTrail(int id, TurtleScene turtScene) {
		Turtle currTurt = (Turtle) myModelController.getData().getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		System.out.println(currTurtLocX);
		System.out.println(currTurtLocY);

		mySlogoImage = new SlogoImage(turtScene, myModelController, id);
		myImage = mySlogoImage.getMyImage();
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);

		myShape = new StraightLine(turtScene, myModelController);
	}

	public void setTurtImage(ImageView image, int id) {
		Turtle currTurt = (Turtle) myModelController.getData().getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		mySlogoImage.setMyImage(image);
		myImage = mySlogoImage.getMyImage();
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);
	}

//	public List<Object> getAllShapes() {
//		return myShape.getAllShapes();
//	}
	
	public Object getRecentShape(){
		int ind =  myShape.getAllShapes().size()-1;
		return myShape.getAllShapes().get(ind);
	}
	
//	public AbstractShape getShape() {
//		return myShape;
//	}

	public ImageView getTurtImage() {
		return myImage;
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
	
	@Override
	public void update(Observable o, Object arg) {
		Data otherSlogoObj = (Data) o;
		
		//when setClear() changes
		if(otherSlogoObj.getTurtle(0).getClearTrail() == true){
			List<Object> currLines = myShape.getAllShapes();
			for (Object line : currLines) myTurtScene.removeChildren((Node) line);
		}
		
		// check if pen down or up
		//when pendown() changes
		List<Point2D> currTrailList = otherSlogoObj.getTurtle(0).getTrail().getPathCoordinates();
		if (otherSlogoObj.getTurtle(0).getPen().isDown() == 1.0) {
			Node currLine = (Node) myShape.drawShape(currTrailList);
			myShape.addShape(currLine);
			myTurtScene.addChildren(currLine);
		}
		
		//when setRotationAngle() changes and setTrail() changes
		double newRotAngle = otherSlogoObj.getTurtle(0).getRotationAngle();
		double newLocX = otherSlogoObj.getTurtle(0).getTrail().getX();
		double newLocY = otherSlogoObj.getTurtle(0).getTrail().getY();
		mySlogoImage.setScreenLoc(newLocX, newLocY);
		mySlogoImage.setRotation(newRotAngle);
		
		//when setScene() changes
		Color newColor = otherSlogoObj.getMyColor();
		GraphicsContext gc = myCanvas.getGraphicsContext2D();
		gc.setFill(newColor);
		gc.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
	}
	
}
