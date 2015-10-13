/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class PenDown extends Command {

	@Override
	public double execute(List<Double> distance, Data data) {
		data.setPen(1);
		return 1;
	}

}
