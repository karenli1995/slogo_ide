/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import view.TurtleScene;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {
//	TurtleScene turtleScene = new TurtleScene();

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {

		this.setValue(0);
		return data;
	}

}
