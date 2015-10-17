/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class YCOR extends Command {
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		distance.clear();
		double y = data.getTurtle(0).getLocation().getY();// - turtleScene.getCentrey();
		this.setValue(y);
		return data;
	}

}
