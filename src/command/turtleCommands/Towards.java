/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import model.Data;
import view.TurtleScene;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {
	TurtleScene turtleScene = new TurtleScene();

	@Override
	public double execute(List<Double> distance, Data data) {

		return 0;
	}

}
