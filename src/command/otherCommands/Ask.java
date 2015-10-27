
package command.otherCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Ask extends Command {

	private Data turtleData;
	private Traverser traverser = new Traverser();

	public Ask(Data turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	private static final long serialVersionUID = 6992411696017450102L;

	@Override
	public double execute(ParseTreeChildren input) {

		int originalID = turtleData.getActiveTurtleID();
		List<Integer> originalActiveList = new ArrayList<Integer>();

		for (int i = 0; i < turtleData.activeTurtleListSize(); i++) {
			originalActiveList.add(turtleData.activeTurtleListValue(i));
		}
		turtleData.clearActiveList();

		List<ParseTreeNode<CommandInterface>> turtles = input.getChildListAt(0);
		// indices of turtles should be affected
		List<Integer> turtleList = new ArrayList<Integer>();
		for (int i = 1; i < turtles.size() - 1; i++) {
			turtleList.add((int) turtles.get(i).getCommandValue());
		}

		int range = 0;
		for (int j = 0; j < turtleList.size(); j++) {
			range = turtleList.get(j).intValue();
			int size = turtleData.turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}

			}

		}

		for (int i = 0; i < turtleList.size(); i++) {
			turtleData.addToActiveList(turtleList.get(i)-1);
		}

		Double answer = 0.0;
		for (int i = 0; i < turtleData.activeTurtleListSize(); i++) {
			turtleData.setActiveTurtle(turtleData.activeTurtleListValue(i));
			turtleData.updateVariableMap(input.getCommandName(0, 1), (double) i);
			answer = traverser.traverse(input.getChildListAt(1), turtleData);
		}
		turtleData.setActiveTurtle(originalID);
		turtleData.clearActiveList();

		for (int i = 0; i < originalActiveList.size(); i++) {
			turtleData.addToActiveList(originalActiveList.get(i));
		}
		return answer;
	}

}
