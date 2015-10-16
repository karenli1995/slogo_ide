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
public class PenDown extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		data.setPen(1);
		this.setValue(1);
		return data;
	}

}
