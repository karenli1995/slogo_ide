/**
 *
 */
package command.math;

import java.util.List;
import java.util.Random;

import command.Command;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

	private Random random = new Random();

	@Override
	public double execute(List<Double> max) {

		return random.nextInt(max.get(0).intValue());
	}

}
