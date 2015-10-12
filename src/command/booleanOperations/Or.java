/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.Command;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Or extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {
		if ((argument.get(0) == 0 && argument.get(1) == 0))
			return 0;
		else
			return 1;

	}


}
