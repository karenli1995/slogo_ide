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
public class Pi extends Command {
	public static final double PI = 3.1416;

	public Pi() {
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {

		this.setValue(PI);
		return PI;
	}

}
