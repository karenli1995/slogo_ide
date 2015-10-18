package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		String varName = argument.get(0).getCommand().getClass().getSimpleName().toString();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		data.setVariableMap(data.getVariableMap());
		return data;
	}

}
