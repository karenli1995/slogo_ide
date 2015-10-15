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
public class PenUp extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		data.setPen(0);
		this.setValue(0);
		return data;
	}

}
