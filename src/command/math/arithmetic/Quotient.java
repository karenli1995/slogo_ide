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
public class Quotient extends Command{
/**
	 * 
	 */
	private static final long serialVersionUID = -5543181629851201807L;

public Quotient(){super();}

	@Override
	public double execute(ParseTreeChildren argument) {

		double quotient = 0;

		try {
			quotient = argument.getCommandValue(0,0) / argument.getCommandValue(1,0);

		} catch (ArithmeticException e) {
			System.out.println("Division by zero is not allowed.");
		}

		this.setValue(quotient);
		return quotient;
	}

}
