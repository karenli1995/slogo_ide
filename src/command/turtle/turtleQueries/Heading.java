/**
 *
 */
package command.turtle.turtleQueries;

import command.Command;
import controller.ParseTreeChildren;
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
	public double execute(ParseTreeChildren distance) {
		double angle = turtleData.getTurtle(0).getRotationAngle();
		this.setValue(angle);
		return angle;
	}

}
