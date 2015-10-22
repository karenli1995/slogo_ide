/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends Command {
	private Data_Turtle_Interface turtleData;
	public TurtleDirection(Data_Turtle_Interface data){
		turtleData= data;
	}
	protected abstract int sign();

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> angle) {
		double angleValue = angle.get(0).getCommand().getValue();
		double newHeadAngle = turtleData.getTurtle(0).getRotationAngle() + ((sign()) * angleValue);
		turtleData.getTurtle(0).setRotationAngle(newHeadAngle);
		this.setValue(angleValue);
		turtleData.setTurtle(0, turtleData.getTurtle(0));
		return angleValue;
	}

}
