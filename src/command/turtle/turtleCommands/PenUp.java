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
public class PenUp extends PenCommands {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1082991179374772194L;

	public PenUp(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected double switchPen() {
		return 0;
	}

}
