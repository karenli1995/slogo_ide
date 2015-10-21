/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class YCoordinate extends CommandInterface {
	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		distance.clear();
		double y = data.getTurtle(0).getTrail().getY();// -
														// turtleScene.getCentrey();
		this.setValue(y);
		return data;
	}

}
