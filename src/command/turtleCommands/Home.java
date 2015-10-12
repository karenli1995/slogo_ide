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
public class Home extends Command {

	MoveTurtle moveTurtle= new MoveTurtle();
	@Override
	public double execute(List<Double> newLocation, Data data) {
		newLocation.clear();
		newLocation.add(0.0);
		newLocation.add(0.0);
		return moveTurtle.calculateDistanceBetweenTwoPoints(newLocation, data);
	}

}
