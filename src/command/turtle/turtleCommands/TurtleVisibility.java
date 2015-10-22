/**
 *
 */
package command.turtle.turtleCommands;

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
public abstract class TurtleVisibility extends Command {
	private Data_Turtle_Interface data;

	public TurtleVisibility(Data_Turtle_Interface turtleData) {
		super(turtleData);
		data = turtleData;
	}

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> angle) {
		data.getTurtle(0).setIsShowing(visibility());
		this.setValue(visibilityValue());
		return visibilityValue();

	}

	protected abstract Boolean visibility();

	protected abstract double visibilityValue();

}
