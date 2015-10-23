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
public class Pi extends Command {
	public static final double PI = 3.1416;

	public Pi() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren argument) {

		this.setValue(PI);
		return PI;
	}

}
