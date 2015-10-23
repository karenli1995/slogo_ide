package command.math;

import command.Command;
import controller.ParseTreeChildren;

public class Sum extends Command {
	public Sum() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren arguments) {

		double sum =arguments.get(0).get(0).getCommandValue()+ arguments.get(1).get(0).getCommandValue();
		this.setValue(sum);
		return sum;

	}

}
