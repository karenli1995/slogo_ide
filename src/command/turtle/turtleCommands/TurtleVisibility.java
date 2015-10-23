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
public abstract class TurtleVisibility extends Command {
	private Data_Turtle_Interface data;

	public TurtleVisibility(Data_Turtle_Interface turtleData) {
		super(turtleData);
		data = turtleData;
	}

	@Override
	public double execute(ParseTreeChildren angle) {
		data.getTurtle(0).setIsShowing(visibility());
		this.setValue(visibilityValue());
		return visibilityValue();

	}

	protected abstract Boolean visibility();

	protected abstract double visibilityValue();

}
