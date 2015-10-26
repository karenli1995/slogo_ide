
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends TurtleAbsolutePosition {

	private static final long serialVersionUID = -667813910576164717L;

	public Home(DataTurtleInterface turtleData) {
		super(turtleData);
	}

	@Override
	public double executeCommand(ParseTreeChildren argument) {
		this.setValue(resetTurtlePosition());
		return resetTurtlePosition();
	}

}
