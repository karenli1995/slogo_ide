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
public class ShowTurtle extends Command {


	@Override
	public Data execute(List<ParseTreeNode<Command>> angle,Data data) {
		data.getTurtle(0).getMyImage().setVisible(true);
		data.getTurtle(0).setIsShowing(1);
		this.setValue(1);
		return data;

	}

}
