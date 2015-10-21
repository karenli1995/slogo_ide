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
public class Pi extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {

		this.setValue(3.1416);
		return data;
	}

}
