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
public class Towards extends Command {
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		this.setValue(0);
		return data;
	}

}
