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
public class Cos  extends Command {

	@Override
	public double execute(List<Double> argument) {

		return Math.cos(Math.toRadians(argument.get(0)));
	}


}
