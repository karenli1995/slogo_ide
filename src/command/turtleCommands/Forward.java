package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

public class Forward extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {

		MoveTurtle moveTurtle = new MoveTurtle();
		moveTurtle.moveFdorBK(distance.get(0).getCommand().getValue(), -1, data.getTurtle(0));
		this.setValue(distance.get(0).getCommand().getValue());
		return data;

	}

}
