package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends Command {

	/* (non-Javadoc)
	 * @see command.Command#execute(java.util.List, model.Data)
	 */
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		// TODO Auto-generated method stub
		return null;
	}


/*	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		System.out.println(data.getVariableMap().size());

		return data;
	}*/

}
