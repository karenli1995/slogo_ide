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
public class Product extends Command {

	@Override
	public int execute(List<Integer> argument) {

		return argument.get(0) * argument.get(1);
	}

}
