package command.syntax;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

public class Constant extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand) {
		return data;
	}

}
