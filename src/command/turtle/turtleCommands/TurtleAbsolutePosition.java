/**
 *
 */
package command.turtle.turtleCommands;

import command.TurtleCommands;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleAbsolutePosition extends TurtleCommands {
	private Data_Turtle_Interface turtleData;

	public TurtleAbsolutePosition(Data_Turtle_Interface turtleData) {
		this.turtleData = turtleData;

	}

	protected double calculateDistanceBetweenTwoPoints(double x2, double y2) {

		double x1 = turtleData.getTurtle(0).getTrail().getX();
		double y1 = turtleData.getTurtle(0).getTrail().getY();

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		return distance;
	}

	protected double  resetTurtlePosition(){
		double distanceMoved = calculateDistanceBetweenTwoPoints(0.0, 0.0);
		updateLocation(0.0, 0.0, 0);
		return distanceMoved;
	}

}
