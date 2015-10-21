/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;
import model.Pen;

/**
 *
 * @author Sally Al
 *
 */
public abstract class PenCommands extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		Pen currPen = data.getTurtle(0).getPen();
		currPen.setPenDown(switchPen());
		data.getTurtle(0).setPen(currPen);
		this.setValue(switchPen());
		return data;
	}

	protected abstract double switchPen();

}
