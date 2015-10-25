/**
 *
 */
package command.turtle.turtleCommands;

import model.DataTurtleInterface;

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

	public Left(DataTurtleInterface turtleData) {
		super(turtleData);
	}

	@Override
	protected int sign() {
		return -1;
	}

}
