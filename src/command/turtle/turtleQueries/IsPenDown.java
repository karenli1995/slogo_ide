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
public class IsPenDown extends Command {
	private Data_Turtle_Interface turtleData;

	public IsPenDown(Data_Turtle_Interface data) {
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
