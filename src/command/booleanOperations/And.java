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
public class And extends Command {
	public And() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren argument) {

		if ((argument.getCommandValue(0,0) != 0 && argument.getCommandValue(1,0) != 0)) {
			this.setValue(1.0);
			return 1.0;
		} else {
			this.setValue(0);
			return 0;
		}
	}



}
