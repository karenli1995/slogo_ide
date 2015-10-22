package command.syntax;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

public class Constant extends Command {
	Data_Turtle_Interface data;

	public Constant() {
	}

	public Constant(Data_Turtle_Interface s) {
		super(s);
		data = s;
	}

	@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {
		return 0;
	}

}
