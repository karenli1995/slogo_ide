package command.math;

import java.util.List;

import command.Command;

public class Sum extends Command {


	@Override
	public double execute(List<Double> argument) {

		return argument.get(0) + argument.get(1);
	}

}
