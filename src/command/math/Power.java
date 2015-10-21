/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public class Power extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> number, Data data, MathCommand mathcommand) {
		this.setValue(Math.pow(number.get(0).getCommand().getValue(), number.get(1).getCommand().getValue()));
		return data;

	}

}
