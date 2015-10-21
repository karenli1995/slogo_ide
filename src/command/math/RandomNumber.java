/**
 *
 */
package command.math;

import java.util.List;
import java.util.Random;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

	private Random random = new Random();

	@Override
	public Data execute(List<ParseTreeNode<Command>> max, Data data, MathCommand mathcommand) {

		this.setValue(random.nextInt((int) max.get(0).getCommand().getValue()));
		return data;
	}

}
