package view.shapes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;
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

	public abstract ArrayList<Line> drawShape(List<Point2D> currTrailList, List<Double> currPenStatus, List<String> penColors, List<Integer> penThicks);

	protected Point2D translateForScreen(Point2D point) {
		double X = point.getX() + myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth() / 2;
		double Y = myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight() / 2 - point.getY();
		return new Point2D(X, Y);
	}
}
