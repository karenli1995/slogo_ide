package view.shapes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;

public class StraightLine extends AbstractShape {
	protected List<Line> myAllShapes = new ArrayList<Line>();

	public StraightLine(TurtleScene turtlescene, ModelController controller) {
		super(turtlescene, controller);
		Line myRecentLine = new Line();
		myAllShapes.add(myRecentLine);
	}

	public List<Line> getAllLines() {
		return myAllShapes;
	}
	
	@Override
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
		
//		if( (X > canvasX2 || X < canvasX1) && checkBounds(modX, Y)) { //if only X needs to be mod
//			Point2D firstPoint = new Point2D(canvasWidth, Y);
//			
//			Point2D secPoint = new Point2D(canvasX1, Y);
//			Point2D thirdPoint = new Point2D( modX, Y);
//			allPoints.add(firstPoint);
//			allPoints.add(secPoint);
//			allPoints.add(thirdPoint);
//		} else if( (Y > canvasY2 || Y < canvasY1) && checkBounds(X, modY)) {
//			Point2D firstPoint = new Point2D(X, canvasHeight);
//			Point2D secPoint = new Point2D(X, modY);
//			allPoints.add(firstPoint);
//			allPoints.add(secPoint);
//		} else if(X != modX && Y != modY) {
//			Point2D = 
//		}
		
		return new Point2D(X, Y);
	}
	

	@Override
	public ArrayList<Line> drawShape(List<Point2D> currTrailList, List<Double> currPenStatus, List<String> penColors, List<Integer> penThicks) {
		int mySceneId = myTurtScene.getIdOfTab();
		ArrayList<Line> ret = new ArrayList<Line>();
		for (int i = 0; i < currTrailList.size() - 1; i++) {
			if (currPenStatus.get(i+1) == 1.0) {
				Point2D point1 = translateForScreen(currTrailList.get(i));
				Point2D point2 = translateForScreen(currTrailList.get(i+1));
				//System.out.println(point1.getY() + " " + point2.getY());
				Line recentLine = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
				recentLine.setStroke(Color.web(penColors.get(i)));
				recentLine.setStrokeWidth(penThicks.get(i));
				myAllShapes.add(recentLine);
				ret.add(recentLine);
			}
		}
		return ret;
		// should call getAllTrails from the Data instead?
	}

}
