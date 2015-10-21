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
public class XCoordinate extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		double x = data.getTurtle(0).getTrail().getX();// -
														// turtleScene.getCentrex();
		this.setValue(x);
		return data;
	}

}
