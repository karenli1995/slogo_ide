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
public class Power extends Command {
	public Power() {
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> number) {
		double power = Math.pow(number.get(0).get(0).getCommandValue(), number.get(1).get(0).getCommand().getValue());
		this.setValue(power);
		return power;

	}

}
