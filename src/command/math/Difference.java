/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public class Difference extends Command {
	public Difference(){
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		double diff = argument.get(0).getCommandValue() - argument.get(1).getCommandValue();
		this.setValue(diff);
		return diff;
	}

}
