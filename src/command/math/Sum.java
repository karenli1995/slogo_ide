package command.math;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

public class Sum extends Command {
	public Sum() {
		super();
	}

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> arguments) {

		double sum =arguments.get(0).getCommandValue()+ arguments.get(1).getCommandValue();
		this.setValue(sum);
		System.out.println(sum);
		return sum;

	}

}
