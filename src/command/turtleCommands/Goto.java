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
public class Goto extends Command {
	MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public double execute(List<Double> newLocation, Data data) {

		return moveTurtle.calculateDistanceBetweenTwoPoints(newLocation, data);
	}

}
