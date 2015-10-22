package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

public class MakeVariable extends Command {

	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {

		String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		return data;
	}

}
