package command.syntax;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

public class Constant extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		return data;
	}

}
