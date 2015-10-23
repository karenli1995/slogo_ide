/**
 *
 */
package command.math.arithmetic;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Negative extends Command {
	public Negative() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren argument) {
		double negative = -(argument.getCommandValue(0,0));
		this.setValue(negative);
		return negative;
	}

}
