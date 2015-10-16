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
public class Log extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> number, Data data) {
		this.setValue(Math.log10(number.get(0).getCommand().getValue()));
		return data;

	}

}
