/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class IsPenDown extends CommandInterface {
	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		this.setValue(data.getTurtle(0).getPen().isDown());
		return data;
	}

}
