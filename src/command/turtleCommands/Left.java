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
public class Left extends TurtleDirection {


	public Left(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected int sign() {
		return -1;
	}

}
