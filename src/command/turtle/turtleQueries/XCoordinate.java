/**
 *
 */
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class XCoordinate extends TurtleCommands {

	private static final long serialVersionUID = 7399635693097670130L;
	private DataTurtleInterface turtleData;

	public XCoordinate(DataTurtleInterface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		double x = getCurrX();
		this.setValue(x);
		return x;
	}


}
