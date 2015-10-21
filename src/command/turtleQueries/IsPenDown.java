/**
 *
 */
package command.turtleQueries;

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
public class IsPenDown extends Command {
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand) {
		this.setValue(data.getTurtle(0).getPen().isDown());
		return data;
	}

}
