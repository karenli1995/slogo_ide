/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends Command {
	protected abstract int sign();

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data, MathCommand mathcommand) {
		SlogoObjects currTurtle = data.getTurtle(0);
		
		double angleValue = angle.get(0).getCommand().getValue();
		double newHeadAngle = currTurtle.getRotationAngle() + ((sign()) * angleValue);
		currTurtle.setRotationAngle(newHeadAngle);
		this.setValue(angleValue);
		
		data.setTurtle(0, currTurtle);
		
		return data;
	}

}
