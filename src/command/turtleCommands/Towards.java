/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {
	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> distance) {
		this.setValue(0);
		return 0;
	}

}
