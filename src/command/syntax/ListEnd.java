
package command.syntax;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class ListEnd extends Command {

	public ListEnd() {

	}

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		return data;
	}

}
