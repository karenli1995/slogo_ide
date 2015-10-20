package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends Command {

<<<<<<< HEAD
	@Override
=======


@Override
>>>>>>> 1036f82d89dcb8bcdb391868c83041dd54da8841
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		return data;
	}

}
