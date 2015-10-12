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
public class Log extends Command {

	@Override
	public double execute(List<Double> number, Data data) {
		return Math.log10(number.get(0));

	}

}
