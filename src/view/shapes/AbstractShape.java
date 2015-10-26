package view.shapes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;
import controller.ModelController;

public abstract class AbstractShape implements ShapeInterface{
	protected TurtleScene myTurtScene;
	protected List<Object> myAllShapes = new ArrayList<Object>();
	protected ModelController myModelController;

	public AbstractShape(TurtleScene turtlescene, ModelController controller) {
		myTurtScene = turtlescene;
		myModelController = controller;
	}
	
	public void addShape(Object shape){
		myAllShapes.add(shape);
	}

	public List<Object> getAllShapes() {
		return myAllShapes;
	}

	public abstract ArrayList<Line> drawShape(List<Point2D> currTrailList, List<Double> currPenStatus, List<String> penColors, List<Integer> penThicks,List<Double> penDash);

	protected Point2D translateForScreen(Point2D point) {
		List<Point2D> allPoints = new ArrayList<Point2D>();
		
		double canvasWidth =  myTurtScene.getCurrTab().getMyCanvasWidth();
		double canvasHeight =  myTurtScene.getCurrTab().getMyCanvasHeight();
		
		double canvasX1 = myTurtScene.getCanvasX();
		double canvasX2 = canvasX1 + canvasWidth;
		double canvasY1 = myTurtScene.getCanvasY();
		double canvasY2 = canvasY1 + canvasHeight;
		
		
//		double X = Math.floorMod( (long) (point.getX() + myTurtScene.getX() + canvasWidth/2) , (long) canvasWidth);
//		double Y = Math.floorMod( (long) (myTurtScene.getY() + canvasHeight/2 - point.getY()), (long) canvasHeight);
		
		double X = point.getX() + myTurtScene.getX() + canvasWidth/2;
		double Y = myTurtScene.getY() + canvasHeight/2 - point.getY();
		double modX = Math.floorMod((long) X, (long) canvasWidth);
		double modY = Math.floorMod((long) Y, (long) canvasHeight);
		
//		if(X != modX && Y == modY) { //if only X needs to be mod
//			Point2D firstPoint = new Point2D(canvasWidth, Y);
//			
//			Point2D secPoint = new Point2D(canvasX1, Y);
//			Point2D thirdPoint = new Point2D( modX, Y);
//			allPoints.add(firstPoint);
//			allPoints.add(secPoint);
//			allPoints.add(thirdPoint);
//		} else if(X == modX && Y != modY) {
//			Point2D firstPoint = new Point2D(X, canvasHeight);
//			Point2D secPoint = new Point2D(X, modY);
//			allPoints.add(firstPoint);
//			allPoints.add(secPoint);
//		} else if(X != modX && Y != modY) {
//			Point2D = 
//		}
		
		return new Point2D(X, Y);
	}
	
	protected boolean checkBounds(double x, double y) {
		TurtleSceneTab currTab = myTurtScene.getCurrTab();
		
		if (x < myTurtScene.getX() || x > myTurtScene.getX() + currTab.getMyCanvasWidth()
				|| y < myTurtScene.getY() || y > myTurtScene.getY() + currTab.getMyCanvasHeight()) {
			return false;
		} else {
			return true;
		}
	}
	
}
