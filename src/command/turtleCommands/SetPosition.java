/**
 *
 */
package command.turtleCommands;
import javafx.geometry.Point2D;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public class SetPosition extends Command {
	//MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public Data execute(List<ParseTreeNode<Command>> newLocation, Data data) {

		//this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(newLocation, data));
		Point2D point = new Point2D(newLocation.get(0).getCommand().getValue(), newLocation.get(1).getCommand().getValue());
		Trail loc = new Trail(point, 0);
		data.getTurtle(0).setLocation(loc);
		return data;
	}

}
