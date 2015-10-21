/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;
import model.Pen;

/**
 *
 * @author Sally Al
 *
 */
public abstract class PenCommands extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand) {
		Pen currPen = data.getTurtle(0).getPen();
		currPen.setPenDown(switchPen());
		data.getTurtle(0).setPen(currPen);
		this.setValue(switchPen());
		return data;
	}

	protected abstract double switchPen();

}
