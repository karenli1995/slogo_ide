/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.Command;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Heading extends Command {
	@Override
	public double execute(List<Double> distance, Data data) {
		return data.getTurtle(0).getMyHeadAngle();
	}

}
