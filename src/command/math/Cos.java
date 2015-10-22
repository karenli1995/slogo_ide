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
public class Cos extends Command {
	public Cos(){
		super();
	}
	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		double cosangle=Math.cos(Math.toRadians(argument.get(0).getCommandValue()));
		this.setValue(cosangle);
		return cosangle;
	}

}
