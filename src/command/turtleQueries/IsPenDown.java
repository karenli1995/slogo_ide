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
public class IsPenDown extends CommandInterface {
	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> distance, Data_Turtle_Interface data) {
		this.setValue(data.getTurtle(0).getPen().isDown());
		return data;
	}

}
