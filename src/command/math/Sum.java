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
	public double execute(List<List<ParseTreeNode<CommandInterface>>> arguments) {

		double sum =arguments.get(0).get(0).getCommandValue()+ arguments.get(1).get(0).getCommandValue();
		this.setValue(sum);
		return sum;

	}

}
