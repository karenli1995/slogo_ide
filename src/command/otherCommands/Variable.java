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

public class Variable extends Command {


	@Override
<<<<<<< HEAD
	public double execute(List<ParseTreeNode<CommandInterface>> argument) {

	/*	String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		System.out.println(data.getVariableMap().size());
*/
		return 0;
=======
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {

		return data;
>>>>>>> c7c65261bf1746f61b3a6579db4674bcf7e70bf3
	}


}
