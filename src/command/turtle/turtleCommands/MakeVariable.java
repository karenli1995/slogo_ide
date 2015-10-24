package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

public class MakeVariable extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3131529990290290269L;
	private Data_Turtle_Interface turtleData;

	public MakeVariable(Data_Turtle_Interface data) {
		super(data);
		 turtleData = data;
	}

@Override
	public double execute(ParseTreeChildren argument) {

		String varName = argument.getCommandName(0,0);
		Double value = argument.getCommandValue(1,0);
		turtleData.updateVaraibleMap(varName, value);
		return value;
	}

}
