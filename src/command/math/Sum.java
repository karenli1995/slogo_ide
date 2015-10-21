package command.math;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

public class Sum extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {

		this.setValue(argument.get(0).getCommand().getValue() + argument.get(1).getCommand().getValue());
		return data;

	}

}
