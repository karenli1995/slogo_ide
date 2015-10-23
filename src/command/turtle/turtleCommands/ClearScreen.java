/**
 *
 */
package command.turtle.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public class ClearScreen extends TurtleAbsolutePosition {
	private Data_Turtle_Interface turtleData;

	public ClearScreen(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {
		List<Double> defaultPosition = new ArrayList<Double>();
		defaultPosition.add(0.0);
		defaultPosition.add(0.0);
		double distanceMoved = calculateDistanceBetweenTwoPoints(defaultPosition);
		this.setValue(distanceMoved);

		SlogoObjects currTurt = turtleData.getTurtle(0);

		currTurt.setRotationAngle(0.0);

		currTurt.setClearTrail(true);
		turtleData.setTurtle(0, currTurt);

		return distanceMoved;
	}

}
