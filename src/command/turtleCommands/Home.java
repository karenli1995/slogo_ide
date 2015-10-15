/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends Command {

	MoveTurtle moveTurtle= new MoveTurtle();
	@Override
	public Data execute(List<ParseTreeNode<Command>> newLocation, Data data) {
		newLocation.clear();
		newLocation.add(0.0);
		newLocation.add(0.0);
		this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(newLocation, data));
		return data;
	}

}
