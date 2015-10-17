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
public class XCOR extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		double x = data.getTurtle(0).getLocation().getX();// - turtleScene.getCentrex();
		this.setValue(x);
		return data;
	}

}
