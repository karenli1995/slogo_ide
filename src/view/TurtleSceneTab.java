package view;

import java.util.Observable;
import java.util.Observer;
import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.SlogoObjects;
import model.Turtle;

public class TurtleSceneTab extends Tab implements Observer{
	private SlogoImage mySlogoImage;
	private ImageView myImage;
	private Turtle myTurtle; //check this
	private Canvas myCanvas;
	private ModelController myModelController;
	private int trailIndex = 1;

	private double myCanvasWidth = SlogoProperties.getSceneWidth()*3/7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight()*5/7;

	public TurtleSceneTab(TurtleScene turtScene, ModelController controller){
		myModelController = controller;
		this.setText("New Text");
		myCanvas = new Canvas();
		myCanvas.setWidth(myCanvasWidth);
		myCanvas.setHeight(myCanvasHeight);
 		GraphicsContext gc = myCanvas.getGraphicsContext2D();
 		setColor(gc, myCanvas, Color.ALICEBLUE);

 		turtScene.getTabs().add(this);

 		int defaultTurt = 0;
 		setTurtle(defaultTurt, turtScene);
 		this.setContent(myCanvas);
	}


	public void setTurtle(int id, TurtleScene turtScene) {
		Turtle currTurt = (Turtle) myModelController.getData().getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		System.out.println(currTurtLocX);
		System.out.println(currTurtLocY);

		mySlogoImage = new SlogoImage(turtScene, myModelController, id);
		myImage = mySlogoImage.getMyImage();
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);
	}

	public void setTurtImage(ImageView image, int id){
		Turtle currTurt = (Turtle) myModelController.getData().getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		mySlogoImage.setMyImage(image);
		myImage = mySlogoImage.getMyImage();
		mySlogoImage.setScreenLoc(currTurtLocX, currTurtLocY);
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

	public SlogoImage getSlogoImage(){
		return mySlogoImage;
	}

	public void drawTrail(){
		if(myModelController.getData().getTurtle(0).getTrail().getPen().isDown()==1){
			Point2D point1 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex-1));
			Point2D point2 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex));
	 		GraphicsContext gc = myCanvas.getGraphicsContext2D();
	 		gc.setStroke(myModelController.getData().getTurtle(0).getTrail().getPen().getColor());
	 		gc.setLineWidth(myModelController.getData().getTurtle(0).getTrail().getPen().getThickness());
	 		gc.strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	 		trailIndex++;
		}
	}

	private Point2D translateForCanvas(Point2D point){
		double X = point.getX() + myCanvasWidth/2;
		double Y = point.getY() + myCanvasHeight/2;
		return new Point2D(X,Y);
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (myModelController.getData().getTurtle(0) == o){
			SlogoObjects otherSlogoObj = (SlogoObjects) o;
			double newRotAngle = otherSlogoObj.getRotationAngle();
			double newLocX = otherSlogoObj.getTrail().getX();
			double newLocY = otherSlogoObj.getTrail().getY();

			/*System.out.println(newLocX);
			System.out.println(newLocY);*/

			
			mySlogoImage.setScreenLoc(newLocX, newLocY);
			mySlogoImage.setRotation(newRotAngle);
			/*System.out.println("karen ");*/
		}else{
			/*System.out.println("jenny ");*/
		}

	}
}
