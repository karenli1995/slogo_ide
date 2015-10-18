/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.Pen;

/**
 *
 * @author Sally Al
 *
 */
public class PenUp extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		Pen currPen = data.getTurtle(0).getPen();
		currPen.setPenDown(0.0);
		data.getTurtle(0).setPen(currPen);
		
		this.setValue(0);
		return data;
	}

}
