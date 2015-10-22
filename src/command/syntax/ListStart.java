package command.syntax;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

public class ListStart extends Command {
	public ListStart() {

	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> distance) {
		return 0;
	}

}
