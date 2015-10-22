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
public class Minus extends Command {
	public Minus() {
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		double negative = -(argument.get(0).get(0).getCommandValue());
		this.setValue(negative);
		return negative;
	}

}
