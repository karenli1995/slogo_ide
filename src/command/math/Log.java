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
public class Log extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> number, Data data) {
		this.setValue(Math.log10(number.get(0).getCommand().getValue()));
		return data;

	}

}
