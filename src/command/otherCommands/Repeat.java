package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class Repeat extends Command {

	public Repeat() {

	}

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		return data;
	}

}
