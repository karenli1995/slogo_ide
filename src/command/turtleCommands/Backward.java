/**
 *
 */
package command.turtleCommands;

import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Backward extends TurtleMovement {


	public Backward(Data data) {
		super(data);
	}

	@Override
	protected int getSign() {
		return -1;
	}

}
