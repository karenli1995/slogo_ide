package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		String varName = argument.get(0).getCommand().toString();
		Double value = argument.get(1).getCommand().getValue();
		System.out.println("make"+" "+varName+" "+value);


	data.updateVaraibleMap("gg", 9.0);
	System.out.println(data.getVariableMap().size());

		return data;
	}

}
