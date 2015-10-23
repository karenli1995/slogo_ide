/**
 *
 */
package command.booleanOperations;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class LessThan extends Command {

	@Override
	public double execute(ParseTreeChildren argument) {
		if (argument.getCommandValue(0,0) < argument.getCommandValue(1,0)) {
			this.setValue(1);
			return 1.0;
		} else {
			this.setValue(0);
			return 0;
		}

	}
}
