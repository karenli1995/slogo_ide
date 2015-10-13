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
public class SetHeading extends Command {
	MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public double execute(List<Double> headingAngle, Data data) {
		Double turtleCurrentHeading = data.getTurtle(0).getMyImage().getRotate();
		Double delta = headingAngle.get(0) - turtleCurrentHeading;
		data.getTurtle(0).getMyImage().setRotate(turtleCurrentHeading + delta);
		data.getTurtle(0).setMyHeadAngle(headingAngle.get(0));
		return delta;
	}

}
