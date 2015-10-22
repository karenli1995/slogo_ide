package command.otherCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
<<<<<<< HEAD
=======
import model.Data;
import model.MathCommand;
>>>>>>> c7c65261bf1746f61b3a6579db4674bcf7e70bf3

public class MakeUserInstruction extends Command {

	@Override
<<<<<<< HEAD
	public double execute(List<ParseTreeNode<CommandInterface>> distance) {
		return 0;
=======
	public Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand) {
		return null;
>>>>>>> c7c65261bf1746f61b3a6579db4674bcf7e70bf3
	}

}
