package command.otherCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

public class UserCommand extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {
		return null;
	}

}
