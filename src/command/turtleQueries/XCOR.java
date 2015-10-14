/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.Command;
import model.Data;
import view.TurtleScene;

/**
 *
 * @author Sally Al
 *
 */
public class XCOR extends Command {
	private static TurtleScene turtleScene = new TurtleScene();

	@Override
	public double execute(List<Double> distance, Data data) {
		double x = data.getTurtle(0).getMyImage().getLayoutX() - turtleScene.getCentrex();
		return x;
	}

}
