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
		double newHeadAngle= data.getTurtle(0).getMyImage().getRotate()+angle.get(0);
		data.getTurtle(0).getMyImage().setRotate(newHeadAngle);
		data.getTurtle(0).setMyHeadAngle(newHeadAngle);
		return angle.get(0);
	}


}
