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
public class YCoordinate extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6465432849463275329L;
	private DataTurtleInterface turtleData;

	public YCoordinate(DataTurtleInterface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {
		//distance.clear();
		double y = turtleData.getTurtle(0).getTrail().getY();

		this.setValue(y);
		return y;
	}

}
