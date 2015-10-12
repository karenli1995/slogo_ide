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
public class Not extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {
		if ((argument.get(0)==0))
			return 1;
		else
			return 0;

	}


}
