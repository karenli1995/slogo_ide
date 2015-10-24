/**
 *
 */
package command.turtle.turtleCommands;

import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class HideTurtle extends TurtleVisibility {

	public HideTurtle(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected Boolean visibility() {
		return false;
	}

	@Override
	protected double visibilityValue() {
		return 0;
	}

}
