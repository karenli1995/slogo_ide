/**
 *
 */
package command.turtle.turtleQueries;

import command.Command;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class IsPenDown extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7464805867540834237L;
	private DataTurtleInterface turtleData;

	public IsPenDown(DataTurtleInterface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {
		double flag = turtleData.getTurtle(0).getPen().isDown();
		this.setValue(flag);
		return flag;
	}

}
