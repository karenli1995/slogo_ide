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
public class Product extends Command {
	public Product() {
		super();
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		double product = argument.get(0).get(0).getCommandValue() * argument.get(1).get(0).getCommandValue();
		this.setValue(product);
		return product;
	}

}
