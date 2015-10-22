/**
 *
 */
package command.turtleCommands;

import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class ShowTurtle extends TurtleVisibility {


	public ShowTurtle(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected Boolean visibility() {
		return true;
	}

	@Override
	protected double visibilityValue() {
		return 1;
	}

}
