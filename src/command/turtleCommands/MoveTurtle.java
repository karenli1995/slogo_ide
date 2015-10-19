/**
 *
 */
package command.turtleCommands;

import java.util.List;

import javafx.geometry.Point2D;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class MoveTurtle {



	public double calculateDistanceBetweenTwoPoints(List<Double> newLocation, Data data) {

		double x1 = data.getTurtle(0).getTrail().getX();
		double y1 = data.getTurtle(0).getTrail().getY();
		double x2 = newLocation.get(0);// + turtleScene.getCentrex();
		double y2 = newLocation.get(1);// + turtleScene.getCentrey();

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		// data.getTurtle(0).getTrail().setX(x2);
		// data.getTurtle(0).getTrail().setY(y2);

		data.getTurtle(0).getTrail().addCoord(new Point2D(x2, y2));

		return distance;
	}

}
