/**
 *
 */
package command.turtle.turtleQueries;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class IsPenDown extends Command {
	private Data_Turtle_Interface turtleData;

	public IsPenDown(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> distance) {
		double flag = turtleData.getTurtle(0).getPen().isDown();
		this.setValue(flag);
		return flag;
	}

}
