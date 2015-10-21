/**
 *
 */
package command.math;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Sine extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {

		this.setValue(Math.sin(Math.toRadians(argument.get(0).getCommand().getValue())));
		return data;
	}

}
