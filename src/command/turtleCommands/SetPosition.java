/**
 *
 */
package command.turtleCommands;

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

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> newLocation, Data_Turtle_Interface data) {
		List<Double> newlocation = new ArrayList<Double>();
		newlocation.add(newLocation.get(0).getCommand().getValue());
		newlocation.add(newLocation.get(1).getCommand().getValue());
		this.setValue(calculateDistanceBetweenTwoPoints(newlocation, data));
		Point2D point = new Point2D(newLocation.get(0).getCommand().getValue(),
				newLocation.get(1).getCommand().getValue());
		addToTrail(data, point);
		return data;
	}

}
