package command.otherCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

public class Variable  extends CommandInterface {


	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> argument, Data_Turtle_Interface data) {

	/*	String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		System.out.println(data.getVariableMap().size());
*/
		return data;
	}


}
