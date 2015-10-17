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
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */// goto x y
public class SetPosition extends Command {
	MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public Data execute(List<ParseTreeNode<Command>> newLocation, Data data) {
		List<Double> newlocation = new ArrayList<Double>();
		newlocation.add(newLocation.get(0).getCommand().getValue());
		newlocation.add(newLocation.get(1).getCommand().getValue());
		this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(newlocation, data));
		Point2D point = new Point2D(newLocation.get(0).getCommand().getValue(),
				newLocation.get(1).getCommand().getValue());
		Trail loc = new Trail(point, 0);

		data.getTurtle(0).setTrail(loc);

		return data;
	}

}
