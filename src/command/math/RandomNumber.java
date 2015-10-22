/**
 *
 */
package command.math;

import java.util.List;
import java.util.Random;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

	private Random random = new Random();

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> max) {
		double randomValue = random.nextInt((int) max.get(0).getCommandValue());
		this.setValue(randomValue);
		System.out.println(randomValue);
		return randomValue;
	}

}
