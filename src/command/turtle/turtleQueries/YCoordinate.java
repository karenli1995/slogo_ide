/**
 *
 */
package command.turtle.turtleQueries;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class YCoordinate extends Command {
	private Data_Turtle_Interface turtleData;

	public YCoordinate(Data_Turtle_Interface data) {
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
