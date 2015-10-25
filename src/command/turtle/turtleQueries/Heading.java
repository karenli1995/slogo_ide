/**
 *
 */
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class Heading extends TurtleCommands {

	private static final long serialVersionUID = 3264254956067658867L;

	public Heading(DataTurtleInterface data) {
		super(data);
		// Data_Turtle_Interface turtleData = data;
	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		double angle = getTurtle().getRotationAngle();
		this.setValue(angle);
		return angle;
	}

}
