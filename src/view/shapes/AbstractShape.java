package view.shapes;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import view.scene.TurtleScene;
import controller.ModelController;

public abstract class AbstractShape {
	protected TurtleScene myTurtScene;
	protected List<Object> myAllShapes = new ArrayList<Object>();
	protected ModelController myModelController;

	public AbstractShape(TurtleScene turtlescene, ModelController controller) {
		myTurtScene = turtlescene;
		myModelController = controller;
	}

	public List<Object> getAllShapes() {
		return myAllShapes;
	}

	public abstract Object drawShape(List<Point2D> currTrailList);

	protected Point2D translateForScreen(Point2D point) {
		double X = point.getX() + myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth() / 2;
		;
		double Y = myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight() / 2 - point.getY();
		return new Point2D(X, Y);
	}
}
