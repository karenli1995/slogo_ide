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
public class Remainder extends Command {

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> argument) {
		double remainder = argument.get(0).getCommandValue() % argument.get(1).getCommandValue();
		this.setValue(remainder);
		return remainder;
	}

}
