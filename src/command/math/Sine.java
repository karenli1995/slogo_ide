/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Sine extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		this.setValue(Math.sin(Math.toRadians(argument.get(0).getCommand().getValue())));
		return data;
	}

}
