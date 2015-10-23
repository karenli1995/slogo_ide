package command.otherCommands;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;

public class DoTimes extends Command {

	@Override
	public double execute(ParseTreeChildren list) {
		int range = (int) list.get(0).get(0).getCommandValue();
		double value =-1.0;
		List<ParseTreeNode<CommandInterface>> commands = list.get(1);
		for(int i = 0 ; i <commands.size(); i++){
			value=commands.get(0).getCommand().execute(list);
		}
		return value;
	}

}
