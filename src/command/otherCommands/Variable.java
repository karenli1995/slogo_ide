package command.otherCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

public class Variable  extends Command {


	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> argument) {

	/*	String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		System.out.println(data.getVariableMap().size());
*/
		return 0;
	}


}
