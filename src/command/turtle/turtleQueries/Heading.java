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
public class Heading extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3264254956067658867L;
	private DataTurtleInterface turtleData;

	public Heading(DataTurtleInterface data) {
		super(data);
		//Data_Turtle_Interface turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {
		double angle = turtleData.getTurtle(0).getRotationAngle();
		this.setValue(angle);
		return angle;
	}

}
