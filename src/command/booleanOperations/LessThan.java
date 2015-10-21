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
public class LessThan extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {
		if (argument.get(0).getCommand().getValue() < argument.get(1).getCommand().getValue()) {
			this.setValue(1);
		} else {
			this.setValue(0);
		}
		return data;
	}
}
