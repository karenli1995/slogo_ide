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
public abstract class TurtleVisibility extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data) {
		data.getTurtle(0).setIsShowing(visibility());
		this.setValue(visibilityValue());
		return data;

	}

	protected abstract Boolean visibility();

	protected abstract double visibilityValue();

}
