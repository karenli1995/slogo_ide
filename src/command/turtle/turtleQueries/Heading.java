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
public class Heading extends Command {
	private Data_Turtle_Interface turtleData;

	public Heading(Data_Turtle_Interface data) {
		super(data);
		Data_Turtle_Interface turtleData = data;
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> distance) {
		double angle = turtleData.getTurtle(0).getRotationAngle();
		this.setValue(angle);
		return angle;
	}

}
