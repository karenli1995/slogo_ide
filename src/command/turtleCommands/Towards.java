/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand) {
		this.setValue(0);
		return data;
	}

}
