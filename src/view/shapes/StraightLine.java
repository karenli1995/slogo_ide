package view.shapes;

import java.util.ArrayList;
import java.util.List;

import controller.ModelController;
import javafx.geometry.Point2D;
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
	public Line drawShape(List<Point2D> currTrailList) {
		// should call getAllTrails from the Data instead?
		int lastPointInList = currTrailList.size() - 1;

		Point2D point1 = translateForScreen(currTrailList.get(lastPointInList - 1));
		Point2D point2 = translateForScreen(currTrailList.get(lastPointInList));

		Line recentLine = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
		recentLine.setStroke(myModelController.getData().getTurtle(0).getTrail().getPen().getColor());
		recentLine.setStrokeWidth(myModelController.getData().getTurtle(0).getTrail().getPen().getThickness());
		myAllShapes.add(recentLine);

		return recentLine;
	}

}
