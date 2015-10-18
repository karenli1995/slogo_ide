package view.shapes;

import java.util.ArrayList;
import java.util.List;

import controller.ModelController;
import view.TurtleScene;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class StraightLine{
	private TurtleScene myTurtScene;
	private List<Line> myAllLines = new ArrayList<Line>();
//	private Line myRecentLine;
	private ModelController myModelController;
	private int myTurtleId;
	
	public StraightLine(TurtleScene turtlescene, ModelController controller, int id){
		myTurtScene = turtlescene;
		Line myRecentLine = new Line();
		myAllLines.add(myRecentLine);
		myTurtleId = id;
	} 
	
	public List<Line> getAllLines(){
		return myAllLines;
	}
	
	public Line drawLine(List<Point2D> currTrailList){
		//should call getAllTrails from the Data instead?
		int lastPointInList = currTrailList.size()-1;

		Point2D point1 = translateForScreen(currTrailList.get(lastPointInList-1));
		Point2D point2 = translateForScreen(currTrailList.get(lastPointInList));

		Line recentLine = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
//		myRecentLine.setStartX(point1.getX());
//		myRecentLine.setStartY(point1.getY());
//		myRecentLine.setEndX(point2.getX());
//		myRecentLine.setEndY(point2.getY());
		myAllLines.add(recentLine);
		
		return recentLine;
//		return myRecentLine;
	}
	
	private Point2D translateForScreen(Point2D point){
		double X = point.getX() + myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth()/2;;
		double Y = myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight()/2 - point.getY();
		return new Point2D(X,Y);
	}
}
