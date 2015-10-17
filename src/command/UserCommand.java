package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data;

public class UserCommand extends Command{

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		return null;
	}

}
