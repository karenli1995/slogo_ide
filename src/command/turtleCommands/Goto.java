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
public class Goto extends Command {
	MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public Data execute(List<ParseTreeNode<Command>> newLocation, Data data) {

		this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(newLocation, data));
		return data;
	}

}
