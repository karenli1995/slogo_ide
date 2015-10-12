package command.math;

import java.util.List;

import command.Command;

public class Sum extends Command {


	@Override
	public int execute(List<Integer> argument) {

		return argument.get(0) + argument.get(1);
	}

}
