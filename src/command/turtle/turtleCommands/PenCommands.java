/**
 *
 */
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;
import model.Pen;

/**
 *
 * @author Sally Al
 *
 */
public abstract class PenCommands extends Command {
	private Data_Turtle_Interface turtleData;

	public PenCommands(Data_Turtle_Interface turtleData) {
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
