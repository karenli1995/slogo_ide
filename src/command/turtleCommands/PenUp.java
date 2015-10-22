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
public class PenUp extends PenCommands {

	public PenUp(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected double switchPen() {
		return 0;
	}

}
