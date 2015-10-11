
package model;

import java.util.ArrayList;
import java.util.List;

import command.Command;

/**
 * @author Sally Al
 **/
public class History {
	List<Command> commandList = new ArrayList<Command>();

	public void addCommand(Command commandName) {
		commandList.add(commandName);
	}

	public List<Command> getHistory() {
		return commandList;
	}

}
