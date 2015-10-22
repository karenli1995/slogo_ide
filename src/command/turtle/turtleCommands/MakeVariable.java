package command.turtle.turtleCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

public class MakeVariable extends Command {

	private Data_Turtle_Interface turtleData;

	public MakeVariable(Data_Turtle_Interface data) {
		super(data);
		 turtleData = data;
	}

@Override
	public double execute(List<List<ParseTreeNode<CommandInterface>>> argument) {

		String varName = argument.get(0).get(0).getCommand().getName();
		Double value = argument.get(1).get(0).getCommand().getValue();
		turtleData.updateVaraibleMap(varName, value);
		return value;
	}

}
