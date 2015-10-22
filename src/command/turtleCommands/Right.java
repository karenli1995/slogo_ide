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
public class Right extends TurtleDirection {

	public Right(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected int sign() {
		return 1;
	}

}
