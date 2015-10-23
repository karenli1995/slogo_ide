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
public class Sine extends Command {

	@Override
	public double execute(ParseTreeChildren argument) {
		double sine =Math.sin(Math.toRadians(argument.get(0).get(0).getCommandValue()));
		this.setValue(sine);
		return sine;
	}

}
