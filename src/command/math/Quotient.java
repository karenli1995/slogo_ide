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
public class Quotient extends Command{
public Quotient(){super();}

	@Override
	public double execute(ParseTreeChildren argument) {

		double quotient = 0;

		try {
			quotient = argument.get(0).get(0).getCommandValue() / argument.get(1).get(0).getCommandValue();

		} catch (ArithmeticException e) {
			System.out.println("Division by zero is not allowed.");
		}

		this.setValue(quotient);
		return quotient;
	}

}
