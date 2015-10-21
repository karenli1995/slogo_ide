package command.otherCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends CommandInterface {



@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {

		String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		return data;
	}

}
