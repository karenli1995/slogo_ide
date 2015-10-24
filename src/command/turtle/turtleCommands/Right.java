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
public class Right extends TurtleDirection {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5679997306598924872L;

	public Right(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected int sign() {
		return 1;
	}

}
