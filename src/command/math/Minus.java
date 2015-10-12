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
public class Minus  extends Command {

	@Override
	public double execute(List<Double> argument) {

		return -(argument.get(0));
	}

}
