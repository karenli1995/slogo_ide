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
public class GreaterThan extends Command {

	@Override
	public double execute(ParseTreeChildren argument) {
		if (argument.get(0).get(0).getCommandValue() > argument.get(1).get(0).getCommandValue()) {
			this.setValue(1);
			return 1.0;
		} else {
			this.setValue(0);
			return 0;
		}

	}

}
