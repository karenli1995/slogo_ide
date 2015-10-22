/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

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
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {

		if ((argument.get(0).get(0).getCommandValue() != 0 && argument.get(1).get(0).getCommandValue() != 0)) {
			this.setValue(1.0);
			System.out.println("Y");
			return 1.0;
		} else {
			this.setValue(0);
			return 0;
		}
	}

}
