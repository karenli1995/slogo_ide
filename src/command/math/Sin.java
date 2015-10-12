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
public class Sin extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {

		return Math.sin(Math.toRadians(argument.get(0)));
	}

}
