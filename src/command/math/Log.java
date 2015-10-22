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
public class Log extends Command {
	public Log(){
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> number) {
		double log =Math.log10(number.get(0).getCommandValue());
		this.setValue(log);
		return log;

	}

}
