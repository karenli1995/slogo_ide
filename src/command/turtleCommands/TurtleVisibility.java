/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleVisibility extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data) {
		SlogoObjects currTurtle = data.getTurtle(0);
		
		currTurtle.setIsShowing(visibility());
		this.setValue(visibilityValue());
		
		data.setTurtle(0, currTurtle);
		
		return data;

	}

	protected abstract Boolean visibility();

	protected abstract double visibilityValue();

}
