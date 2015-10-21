package command.otherCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

public class Repeat extends CommandInterface {

	public Repeat() {

	}

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		return data;
	}

}
