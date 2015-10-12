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
public class Log extends Command {

	@Override
	public double execute(List<Double> number) {
		return Math.log10(number.get(0));

	}

}
