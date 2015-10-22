/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public class Sine extends Command {

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		double sine =Math.sin(Math.toRadians(argument.get(0).get(0).getCommandValue()));
		this.setValue(sine);
		return sine;
	}

}
