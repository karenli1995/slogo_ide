package command.syntax;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

public class ListStart extends CommandInterface {
	public ListStart() {

	}

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> distance, Data_Turtle_Interface data) {
		return data;
	}

}
