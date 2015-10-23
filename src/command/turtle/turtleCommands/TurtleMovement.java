/**
 *
 */
package command.turtle.turtleCommands;

import java.util.HashMap;
import java.util.Map;

import command.RoundingResults;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleMovement extends RoundingResults {
	/**
	 * @param allData
	 */
	private Map<String, Double> coordinates = new HashMap<String, Double>();

	private static final String XCOR = "XCor";
	private static final String YCOR = "YCor";
	private static final String ANGLE = "Angle";

	public TurtleMovement(Data_Turtle_Interface allData) {
		super(allData);
		data = allData;

	}

	private void updateLocation(Double x, Double y, double angle) {

		coordinates.put(XCOR, x);
		coordinates.put(YCOR, y);
		coordinates.put(ANGLE, angle);
		setChanged();
		notifyObservers();
	}

	public Map<String, Double> getCoordinates() {
		return coordinates;
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
