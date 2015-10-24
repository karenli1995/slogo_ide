/**
 *
 */
package command.turtle.turtleCommands;

import command.TurtleCommands;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleMovement extends TurtleCommands {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8387538421594848834L;

	public TurtleMovement(Data_Turtle_Interface allData) {
		super(allData);
		data = allData;

	}


	private Data_Turtle_Interface data;

	@Override
	public double execute(ParseTreeChildren distance) {

		SlogoObjects currTurtle = data.getTurtle(0);
		moveFdorBK(distance.getCommandValue(0, 0), currTurtle);
		setValue(distance.getCommandValue(0, 0));
		return distance.getCommandValue(0, 0);

	}

	public void moveFdorBK(double distance, SlogoObjects myTurtle) {
		int sign = getSign();

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		double tempXLocation = RoundTo2Decimals(Math.sin(radians));
		double tempYLocation = RoundTo2Decimals(Math.cos(radians));

		tempXLocation = calcualteCoordinate(tempXLocation, myTurtle.getTrail().getX(), sign, distance);
		tempYLocation = calcualteCoordinate(tempYLocation, myTurtle.getTrail().getY(), sign, distance);

		updateLocation(tempXLocation, tempYLocation, degrees);

	}

	private double calcualteCoordinate(double Tempcoordinate, double previousCoordinate, int sign, double distance) {
		if (Tempcoordinate == 0.0 || Tempcoordinate == -0.0) {
			return previousCoordinate;
		} else {

			return (previousCoordinate + (sign * (distance / Tempcoordinate)));
		}
	}

	protected abstract int getSign();
}
