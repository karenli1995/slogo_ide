/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends Command {
	protected abstract int sign();

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data) {
		double angleValue = angle.get(0).getCommand().getValue();
		double newHeadAngle = data.getTurtle(0).getRotationAngle() + ((sign()) * angleValue);
		data.getTurtle(0).setRotationAngle(newHeadAngle);
		this.setValue(angleValue);
		return data;
	}

}
