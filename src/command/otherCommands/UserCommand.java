package command.otherCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

public class UserCommand extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> argument, Data_Turtle_Interface data) {
		return null;
	}

}
