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
		double sine =Math.sin(Math.toRadians(argument.getCommandValue(0,0)));
		this.setValue(sine);
		return sine;
	}

}
