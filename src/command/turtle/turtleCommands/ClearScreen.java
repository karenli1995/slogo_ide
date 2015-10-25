/**
 *
 */
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class ClearScreen extends TurtleAbsolutePosition {
	/**
	 *
	 */
	private static final long serialVersionUID = -240865876563370225L;
	private DataTurtleInterface turtleData;

	public ClearScreen(DataTurtleInterface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		int x =0;
		this.setValue(resetTurtlePosition());
		getTurtle().setClearTrail(true);
		return resetTurtlePosition();

	}

}
