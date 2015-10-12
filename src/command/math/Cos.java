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
public class Cos  extends Command {

	@Override
	public double execute(List<Double> argument, Data data) {

		return Math.cos(Math.toRadians(argument.get(0)));
	}


}
