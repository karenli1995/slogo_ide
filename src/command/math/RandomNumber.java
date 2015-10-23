/**
 *
 */
package command.math;

import java.util.Random;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

	private Random random = new Random();

	@Override
	public double execute(ParseTreeChildren max) {
		double randomValue = random.nextInt((int) max.get(0).get(0).getCommandValue());
		this.setValue(randomValue);
		return randomValue;
	}

}
