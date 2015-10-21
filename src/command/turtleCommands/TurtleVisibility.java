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
public abstract class TurtleVisibility extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> angle, Data_Turtle_Interface data) {
		data.getTurtle(0).setIsShowing(visibility());
		this.setValue(visibilityValue());
		return data;

	}

	protected abstract Boolean visibility();

	protected abstract double visibilityValue();

}
