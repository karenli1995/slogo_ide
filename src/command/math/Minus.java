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
public class Minus extends Command {
	public Minus() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren argument) {
		double negative = -(argument.get(0).get(0).getCommandValue());
		this.setValue(negative);
		return negative;
	}

}
