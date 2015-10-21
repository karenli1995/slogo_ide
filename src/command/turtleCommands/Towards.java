/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends CommandInterface {
	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		this.setValue(0);
		return data;
	}

}
