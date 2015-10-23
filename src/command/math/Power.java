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
public class Power extends Command {
	public Power() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren number) {
		double power = Math.pow(number.get(0).get(0).getCommandValue(), number.get(1).get(0).getCommand().getValue());
		this.setValue(power);
		return power;

	}

}
