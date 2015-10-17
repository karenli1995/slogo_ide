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
public class Minus  extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		this.setValue(-(argument.get(0).getCommand().getValue()));
		return data;
	}

}
