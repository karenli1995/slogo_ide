package command.math.arithmetic;

import command.otherCommands.UnlimitedInputCommand;
import controller.ParseTreeChildren;
import model.data.Data;

public class Sum extends UnlimitedInputCommand {

	private static final long serialVersionUID = -3214409066608523993L;

	public Sum(Data allData) {
		super(allData);
	}

	@Override
	public double execute(ParseTreeChildren arguments) {

		double sum = parameterLoop((list) -> list.stream().reduce((x, y) -> x + y).get(), arguments);
		this.setValue(sum);
		return sum;

	}

}
