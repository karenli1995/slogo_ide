/**
 *
 */
package command.math;

import java.util.List;
import java.util.Random;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

	private Random random = new Random();

	@Override
	public Data execute(List<ParseTreeNode<Command>> max, Data data) {

		this.setValue(random.nextInt((int) max.get(0).getCommand().getValue()));
		return data;
	}

}
