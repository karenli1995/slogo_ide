
package command.syntax;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

public class ListEnd extends Command {

	public ListEnd() {

	}

	@Override
	public  double execute(List<ParseTreeNode<CommandInterface>> distance) {
		return 0;
	}

}
