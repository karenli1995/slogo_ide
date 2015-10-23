/**
 *
 */
package command.math;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Remainder extends Command {

	@Override
	public double execute(ParseTreeChildren argument) {
		double remainder = argument.get(0).get(0).getCommandValue() % argument.get(1).get(0).getCommandValue();
		this.setValue(remainder);
		return remainder;
	}

}
