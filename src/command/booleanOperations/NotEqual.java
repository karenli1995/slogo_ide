/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.Command;

/**
 *
 * @author Sally Al
 *
 */
public class NotEqual extends Command {

	@Override
	public int execute(List<Integer> argument) {
		if (argument.get(0) != argument.get(1)) {
			return 1;
		} else {
			return 0;
		}
	}

}
