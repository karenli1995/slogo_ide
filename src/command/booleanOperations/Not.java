/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Not extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		if ((argument.get(0).getCommand().getValue() == 0))
			this.setValue(1);
		else
			this.setValue(0);

		return data;

	}

}
