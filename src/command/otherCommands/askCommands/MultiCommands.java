
package command.otherCommands.askCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public abstract class MultiCommands extends Command {

	private static final long serialVersionUID = 456274188677983060L;
	Data turtleData;
	protected int originalID;
	protected List<Integer> originalActiveList;


	public MultiCommands(Data turtleData) {
		this.turtleData = turtleData;
		originalID = turtleData.getActiveTurtleID();
		originalActiveList = new ArrayList<Integer>();


	}

	protected void backUpActive() {
		for (int i = 0; i < turtleData.activeTurtleListSize(); i++) {
			originalActiveList.add(turtleData.activeTurtleListValue(i));
		}
	}

	protected void createTempActivleList(List<ParseTreeNode<CommandInterface>> turtles, List<Integer> newActiveList) {
		for (int i = 1; i < turtles.size() - 1; i++) {
			newActiveList.add((int) turtles.get(i).getCommandValue());
		}
	}



	protected void resetActiveList() {
		for (int i = 0; i < originalActiveList.size(); i++) {
			turtleData.addToActiveList(originalActiveList.get(i));
		}
	}

}
