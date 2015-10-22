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
public class Or extends Command {

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> argument) {
		if ((argument.get(0).getCommandValue() == 0 && argument.get(1).getCommandValue() == 0)) {
			this.setValue(0);
			return 0;
		} else {
			this.setValue(1);
			return 1.0;
		}

	}

}
