/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Quotient extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {

		double quotient = 0;

		try {
			quotient = argument.get(0) / argument.get(1);

		} catch (ArithmeticException e) {
			System.out.println("Division by zero is not allowed.");
		}

		return quotient;
	}

}
