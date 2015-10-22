/**
 *
 */
package command.turtle.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
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
	public double execute(List<ParseTreeNode<CommandInterface>> newLocation) {
		List<Double> newlocation = new ArrayList<Double>();
		newlocation.add(newLocation.get(0).getCommandValue());
		newlocation.add(newLocation.get(1).getCommandValue());
		double distance = calculateDistanceBetweenTwoPoints(newlocation);
		this.setValue(distance);
		Point2D point = new Point2D(newLocation.get(0).getCommand().getValue(),
				newLocation.get(1).getCommand().getValue());
		addToTrail(point);
		return distance;
	}

}
