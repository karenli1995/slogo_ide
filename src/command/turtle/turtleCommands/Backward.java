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


	/**
	 * 
	 */
	private static final long serialVersionUID = 6054146528991269604L;

	public Backward(Data_Turtle_Interface data) {
		super(data);
	}

	@Override
	protected int getSign() {
		return -1;
	}

}
