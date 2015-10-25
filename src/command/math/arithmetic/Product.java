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
public class Product extends UnlimitedInputCommand {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3795052450458213450L;

	public Product() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren arguments) {
	        double sum = parameterLoop((list) -> list.stream().reduce((x,y) -> x*y).get() , arguments);
	        this.setValue(sum);
	        return sum;
	}

}
