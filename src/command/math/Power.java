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
public class Power extends Command {

	@Override
	public double execute(List<Double> number, Data data) {
		return Math.pow(number.get(0), number.get(1));

	}

}
