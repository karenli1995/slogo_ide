/**
 *
 */
package command.math.arithmetic;

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
		double product = argument.getCommandValue(0,0) * argument.getCommandValue(1,0);
		this.setValue(product);
		return product;
	}

}
