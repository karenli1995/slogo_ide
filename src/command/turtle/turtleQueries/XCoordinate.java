
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class XCoordinate extends TurtleCommands {

	private static final long serialVersionUID = 7399635693097670130L;

	public XCoordinate(DataTurtleInterface data) {
		super(data);
	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		double x = getCurrX();
		setValue(x);
		return x;
	}

}
