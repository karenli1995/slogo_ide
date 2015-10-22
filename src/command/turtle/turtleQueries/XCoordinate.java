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
public class XCoordinate extends Command {
	private Data_Turtle_Interface turtleData;

	public XCoordinate(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> distance) {
		double x = turtleData.getTurtle(0).getTrail().getX();
		// turtleScene.getCentrex();
		this.setValue(x);
		return x;
	}

}
