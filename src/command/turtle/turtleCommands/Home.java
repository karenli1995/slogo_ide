/**
 *
 */
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends TurtleAbsolutePosition {
	private Data_Turtle_Interface turtleData;

	public Home(Data_Turtle_Interface turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	@Override
	public double execute(ParseTreeChildren argument) {
		this.setValue(resetTurtlePosition());
		return resetTurtlePosition();
	}

}
