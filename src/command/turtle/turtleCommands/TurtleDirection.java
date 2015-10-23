/**
 *
 */
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
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
	public double execute(ParseTreeChildren angle) {
		double angleValue = angle.getCommandValue(0,0);
		double newHeadAngle = turtleData.getTurtle(0).getRotationAngle() + ((sign()) * angleValue);
		turtleData.getTurtle(0).setRotationAngle(newHeadAngle);
		this.setValue(angleValue);
		turtleData.setTurtle(0, turtleData.getTurtle(0));
		return angleValue;
	}

}
