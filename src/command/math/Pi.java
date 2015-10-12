/**
 *
 */
package command.math;

import java.util.List;

import command.Command;

/**
 *
 * @author Sally Al
 *
 */
public class Pi extends Command {

	@Override
	public double execute(List<Double> argument) {

		return 3.1416;
	}

}
