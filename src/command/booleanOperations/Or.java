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
public class Or extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> argument, Data_Turtle_Interface data) {
		if ((argument.get(0).getCommand().getValue() == 0 && argument.get(1).getCommand().getValue() == 0))
			this.setValue(0);
		else
			this.setValue(1);
		return data;

	}

}
