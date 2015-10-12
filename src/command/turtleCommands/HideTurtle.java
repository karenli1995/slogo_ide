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
public class HideTurtle extends Command {


	@Override
	public double execute(List<Double> angle,Data data) {
		data.getTurtle(0).getMyImage().setVisible(false);
		return 0;

	}

}
