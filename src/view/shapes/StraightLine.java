package view.shapes;

import java.util.List;
import controller.ModelController;
import view.TurtleScene;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class StraightLine{
	private TurtleScene myTurtScene;
	private Line myLine;
	private ModelController myModelController;
	private int myTurtleId;
	
	public StraightLine(TurtleScene turtlescene, ModelController controller, int id){
		myTurtScene = turtlescene;
		myLine = new Line();
		myTurtleId = id;
	} 
	
	public Line drawLine(List<Point2D> currTrailList){
		//should call getAllTrails from the Data instead?
		int lastPointInList = currTrailList.size()-1;

		Point2D point1 = translateForScreen(currTrailList.get(lastPointInList-1));
		Point2D point2 = translateForScreen(currTrailList.get(lastPointInList));

		myLine.setStartX(point1.getX());
		myLine.setStartY(point1.getY());
		myLine.setEndX(point2.getX());
		myLine.setEndY(point2.getY());
		
		return myLine;
	}
	
	private Point2D translateForScreen(Point2D point){
		double X = point.getX() + myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth()/2;;
		double Y = myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight()/2 - point.getY();
		return new Point2D(X,Y);
	}
}
