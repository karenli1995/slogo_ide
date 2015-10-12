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
public class Atan extends Command {

	@Override
	public double execute(List<Double> angle) {
		if (angle.get(0) % 90 == 0) {
			return 0;
		} else {
			return Math.atan(Math.toRadians(angle.get(0)));
		}
	}

}
