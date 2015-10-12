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
public class And extends Command {

	@Override
	public double execute(List<Double> argument) {
		if ((argument.get(0) != 0 && argument.get(1) != 0))
			return 1;
		else
			return 0;

	}

}
