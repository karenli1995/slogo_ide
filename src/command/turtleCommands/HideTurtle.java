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
public class HideTurtle extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data) {
		data.getTurtle(0).setIsShowing(false);
		this.setValue(0);
		System.out.println("hide");
		return data;

	}

}
