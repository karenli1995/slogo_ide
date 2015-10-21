/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public class Or extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {
		if ((argument.get(0).getCommand().getValue() == 0 && argument.get(1).getCommand().getValue() == 0))
			this.setValue(0);
		else
			this.setValue(1);
		return data;

	}

}
