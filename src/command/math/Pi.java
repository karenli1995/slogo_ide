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
public class Pi extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		this.setValue(3.1416);
		return data;
	}

}
