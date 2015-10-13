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
public class PenUp extends Command {

	@Override
	public double execute(List<Double> distance, Data data) {
		data.setPen(0);
		return 0;
	}

}
