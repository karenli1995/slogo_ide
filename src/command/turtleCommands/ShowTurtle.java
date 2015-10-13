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
public class ShowTurtle extends Command {


	@Override
	public double execute(List<Double> angle,Data data) {
		data.getTurtle(0).getMyImage().setVisible(true);
		data.getTurtle(0).setIsShowing(1);
		return 1;

	}

}
