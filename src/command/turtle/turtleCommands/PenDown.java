/**
 *
 */
package command.turtle.turtleCommands;

import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class PenDown extends PenCommands {


	public PenDown(Data turtleData) {
		super(turtleData);
	}

	@Override
	protected double switchPen() {
		return 1.0;
	}

}
