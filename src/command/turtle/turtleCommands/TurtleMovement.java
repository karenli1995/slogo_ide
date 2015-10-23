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

		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));
		// will re-factor this later
		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getTrail().getX();
		} else {
			tempXLocation = myTurtle.getTrail().getX() + ((sign) * distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation = (myTurtle.getTrail().getY());
		} else {
			tempYLocation = myTurtle.getTrail().getY() + (sign * (distance / Math.cos(radians)));
		}

				updateLocation(tempXLocation, tempYLocation,degrees);


	}

	protected abstract int getSign();
}
