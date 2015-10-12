/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Pi extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {

		return 3.1416;
	}

}
