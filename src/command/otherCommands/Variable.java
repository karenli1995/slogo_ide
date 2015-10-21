package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class Variable extends Command {


	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {

		return data;
	}


}
