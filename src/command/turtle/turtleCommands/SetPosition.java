/**
 *
 */
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */// goto x y
public class SetPosition extends TurtleAbsolutePosition {
	Data_Turtle_Interface turtleData;

	public SetPosition(Data_Turtle_Interface turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	@Override
	public double execute(ParseTreeChildren newLocation) {
		double distance = calculateDistanceBetweenTwoPoints(newLocation.getCommandValue(0,0),newLocation.getCommandValue(1,0));
		this.setValue(distance);
		updateLocation(newLocation.getCommandValue(0,0), newLocation.getCommandValue(1,0),  turtleData.getTurtle(0).getRotationAngle());
		return distance;
	}

}
