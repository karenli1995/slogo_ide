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
public class GreaterThan extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		if (argument.get(0).getCommand().getValue() > argument.get(1).getCommand().getValue()) {
			this.setValue(1);
		} else {
			this.setValue(0);
		}
		return data;
	}

}
