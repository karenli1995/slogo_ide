package command.otherCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

public class UserCommand extends Command {

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> distance) {
		return 0;
	}

}
