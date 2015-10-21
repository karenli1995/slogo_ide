package command.math;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

public class Sum extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {

		mathcommand.setMathValue(argument.get(0).getCommand().getValue() + argument.get(1).getCommand().getValue());
		return data;

	}

}
