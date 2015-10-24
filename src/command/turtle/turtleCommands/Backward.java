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
public class Backward extends TurtleMovement {


	public Backward(Data_Turtle_Interface data) {
		super(data);
	}

	@Override
	protected int getSign() {
		return -1;
	}

}
