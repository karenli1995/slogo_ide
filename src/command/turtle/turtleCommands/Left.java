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
public class Left extends TurtleDirection {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4725890321281815700L;

	public Left(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected int sign() {
		return -1;
	}

}
