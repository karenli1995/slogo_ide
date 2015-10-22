/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import javafx.geometry.Point2D;
import model.Data_Turtle_Interface;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleAbsolutePosition extends Command {
	private Data_Turtle_Interface turtleData;

	public TurtleAbsolutePosition(Data_Turtle_Interface turtleData) {
		this.turtleData = turtleData;

	}

	protected double calculateDistanceBetweenTwoPoints(List<Double> newLocation) {

		double x1 = turtleData.getTurtle(0).getTrail().getX();
		double y1 = turtleData.getTurtle(0).getTrail().getY();
		double x2 = newLocation.get(0);
		double y2 = newLocation.get(1);

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		turtleData.getTurtle(0).getTrail().addCoord(new Point2D(x2, y2));

		return distance;
	}

	protected void addToTrail(Point2D point) {
		Trail loc = turtleData.getTurtle(0).getTrail();
		loc.setPoint(point);
		turtleData.getTurtle(0).setTrail(loc);
		turtleData.getTurtle(0).getTrail().addCoord(point);
		turtleData.setTurtle(0, turtleData.getTurtle(0));



	}

}
