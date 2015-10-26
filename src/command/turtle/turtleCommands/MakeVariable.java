package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

public class MakeVariable extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3131529990290290269L;
	private DataTurtleInterface turtleData;

	public MakeVariable(DataTurtleInterface data) {
		super(data);
		 turtleData = data;
	}

@Override
	public double execute(ParseTreeChildren argument) {

		String varName = argument.getCommandName(0,0);
		Double value = argument.getCommandValue(1,0);
		turtleData.updateVariableMap(varName, value);
		return value;
	}

}
