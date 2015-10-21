/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Not extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {
		if ((argument.get(0).getCommand().getValue() == 0))
			this.setValue(1);
		else
			this.setValue(0);

		return data;

	}

}
