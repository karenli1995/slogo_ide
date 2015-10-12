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
public class Right extends Command {




	@Override
	public double execute(List<Double> angle, Data data) {
		data.getTurtle(0).getMyImage().setRotate(data.getTurtle(0).getMyImage().getRotate()+angle.get(0));

		return angle.get(0);
	}


}
