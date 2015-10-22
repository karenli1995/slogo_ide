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
public class YCoordinate extends Command {
	private Data_Turtle_Interface turtleData;

	public YCoordinate(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> distance) {
		distance.clear();
		double y = turtleData.getTurtle(0).getTrail().getY();

		this.setValue(y);
		return y;
	}

}
