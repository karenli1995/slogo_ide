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
		double remainder = argument.getCommandValue(0,0) % argument.getCommandValue(1,0);
		this.setValue(remainder);
		return remainder;
	}

}
