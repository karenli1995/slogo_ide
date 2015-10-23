/**
 *
 */
package command.math;

import command.Command;
import controller.ParseTreeChildren;

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
	public double execute(ParseTreeChildren argument) {
		double product = argument.get(0).get(0).getCommandValue() * argument.get(1).get(0).getCommandValue();
		this.setValue(product);
		return product;
	}

}
