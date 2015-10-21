/**
 *
 */
package command.math;

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
public class Cos extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {

		this.setValue(value);
		Math.cos(Math.toRadians(argument.get(0).getCommand().getValue()));
		return data;
	}

}
