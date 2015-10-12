package command.math;

import java.util.List;

import command.Command;
import model.Data;

public class Sum extends Command {


	@Override
	public double execute(List<Double> argument, Data data) {

		return argument.get(0) + argument.get(1);
	}

}
