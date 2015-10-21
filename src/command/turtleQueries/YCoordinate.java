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
public class YCoordinate extends CommandInterface {
	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> distance, Data_Turtle_Interface data) {
		distance.clear();
		double y = data.getTurtle(0).getTrail().getY();// -
														// turtleScene.getCentrey();
		this.setValue(y);
		return data;
	}

}
