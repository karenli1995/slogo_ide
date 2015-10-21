/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends CommandInterface {
	protected abstract int sign();

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> angle, Data_Turtle_Interface data) {
		double angleValue = angle.get(0).getCommand().getValue();
		double newHeadAngle = data.getTurtle(0).getRotationAngle() + ((sign()) * angleValue);
		data.getTurtle(0).setRotationAngle(newHeadAngle);
		this.setValue(angleValue);
		return data;
	}

}
