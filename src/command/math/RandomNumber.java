/**
 *
 */
package command.math;

import java.util.List;
import java.util.Random;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends CommandInterface {

	private Random random = new Random();

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> max, Data data) {

		this.setValue(random.nextInt((int) max.get(0).getCommand().getValue()));
		return data;
	}

}
