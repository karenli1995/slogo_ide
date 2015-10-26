
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class YCoordinate extends TurtleCommands {

	private static final long serialVersionUID = 6465432849463275329L;

	public YCoordinate(DataTurtleInterface data) {
		super(data);

	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		double y = getCurrY();
		setValue(y);
		return y;
	}

}
