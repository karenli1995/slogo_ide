/**
 *
 */
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;
import model.turtleinfo.Pen;

/**
 *
 * @author Sally Al
 *
 */
public abstract class PenCommands extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7003996375537002670L;
	private DataTurtleInterface turtleData;

	public PenCommands(DataTurtleInterface turtleData) {
		this.turtleData = turtleData;


	}

	@Override
	public double execute(ParseTreeChildren distance) {
		Pen currPen = turtleData.getTurtle(0).getPen();
		currPen.setPenDown(switchPen());
		turtleData.getTurtle(0).setPen(currPen);
		this.setValue(switchPen());
		return switchPen();
	}

	protected abstract double switchPen();

}
