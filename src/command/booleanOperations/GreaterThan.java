/**
 *
 */
package command.booleanOperations;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class GreaterThan extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> argument, Data_Turtle_Interface data) {
		if (argument.get(0).getCommand().getValue() > argument.get(1).getCommand().getValue()) {
			this.setValue(1);
		} else {
			this.setValue(0);
		}
		return data;
	}

}
