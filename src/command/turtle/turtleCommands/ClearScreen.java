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
public class ClearScreen extends TurtleAbsolutePosition {
	private Data_Turtle_Interface turtleData;

	public ClearScreen(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {

		this.setValue(resetTurtlePosition());
		turtleData.getTurtle(0).setClearTrail(true);
		return resetTurtlePosition();
	}

}
