/**
 *
 */
package command.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */// goto x y
public class SetPosition extends TurtleAbsolutePosition {

	@Override
	public Data execute(List<ParseTreeNode<Command>> newLocation, Data data) {
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
