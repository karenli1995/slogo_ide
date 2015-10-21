/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.CommandInterface;
import javafx.geometry.Point2D;
import model.Data;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleAbsolutePosition extends CommandInterface {

	protected double calculateDistanceBetweenTwoPoints(List<Double> newLocation, Data data) {

		double x1 = data.getTurtle(0).getTrail().getX();
		double y1 = data.getTurtle(0).getTrail().getY();
		double x2 = newLocation.get(0);
		double y2 = newLocation.get(1);

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		data.getTurtle(0).getTrail().addCoord(new Point2D(x2, y2));

		return distance;
	}

	protected void addToTrail(Data data, Point2D point) {
		Trail loc = data.getTurtle(0).getTrail();
		loc.setPoint(point);
		data.getTurtle(0).setTrail(loc);
		data.getTurtle(0).getTrail().addCoord(point);
	}

}
