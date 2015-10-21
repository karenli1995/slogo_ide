/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class XCoordinate extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> distance, Data_Turtle_Interface data) {
		double x = data.getTurtle(0).getTrail().getX();// -
														// turtleScene.getCentrex();
		this.setValue(x);
		return data;
	}

}
