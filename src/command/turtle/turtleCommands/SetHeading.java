/**
 *
 */
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class SetHeading extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6593453308174239806L;
	private Data_Turtle_Interface turtleData;

	public SetHeading(Data_Turtle_Interface turtleDate) {
		this.turtleData = turtleDate;
	}

	@Override
	public double execute(ParseTreeChildren headingAngle) {
		Double turtleCurrentHeading = turtleData.getTurtle(0).getRotationAngle();
		Double delta = headingAngle.getCommandValue(0,0) - turtleCurrentHeading;
		turtleData.getTurtle(0).setRotationAngle(turtleCurrentHeading + delta);
		this.setValue(delta);
		turtleData.setTurtle(0, turtleData.getTurtle(0));
		return delta;
	}

}
