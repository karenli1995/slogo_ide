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
public class Or extends Command {

	@Override
	public double execute(ParseTreeChildren argument) {
		if ((argument.get(0).get(0).getCommandValue() == 0 && argument.get(1).get(0).getCommandValue() == 0)) {
			this.setValue(0);
			return 0;
		} else {
			this.setValue(1);
			return 1.0;
		}

	}

}
