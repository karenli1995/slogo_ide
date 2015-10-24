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
public class ShowTurtle extends TurtleVisibility {


	/**
	 * 
	 */
	private static final long serialVersionUID = -234848329032905536L;

	public ShowTurtle(Data_Turtle_Interface turtleData) {
		super(turtleData);
	}

	@Override
	protected Boolean visibility() {
		return true;
	}

	@Override
	protected double visibilityValue() {
		return 1;
	}

}
