/**
 *
 */
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {
	@Override
	public double execute(ParseTreeChildren distance) {
		this.setValue(0);
		return 0;
	}

}
