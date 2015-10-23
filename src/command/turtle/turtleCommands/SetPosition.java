/**
 *
 */
package command.turtle.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import controller.ParseTreeChildren;
import javafx.geometry.Point2D;
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
		List<Double> newlocation = new ArrayList<Double>();
		newlocation.add(newLocation.getCommandValue(0,0));
		newlocation.add(newLocation.getCommandValue(1,0));
		double distance = calculateDistanceBetweenTwoPoints(newlocation);
		this.setValue(distance);
		Point2D point = new Point2D(newLocation.getCommandValue(0,0),
				newLocation.getCommandValue(1,0));
		addToTrail(point);
		return distance;
	}

}
