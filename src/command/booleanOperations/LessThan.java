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
		if (argument.get(0).get(0).getCommand().getValue() < argument.get(1).get(0).getCommand().getValue()) {
			this.setValue(1);
			return 1.0;
		} else {
			this.setValue(0);
			return 0;
		}

	}
}
