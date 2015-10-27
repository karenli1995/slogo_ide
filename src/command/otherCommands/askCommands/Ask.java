
package command.otherCommands.askCommands;

import java.util.ArrayList;
import java.util.List;

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
public class Ask extends MultiCommands {

	private Data turtleData;
	private Traverser traverser = new Traverser();

	public Ask(Data turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	private static final long serialVersionUID = 6992411696017450102L;

	@Override
	public double execute(ParseTreeChildren input) {
		List<Integer> newActiveList = new ArrayList<Integer>();

		this.backUpActive();
		turtleData.clearActiveList();
		List<ParseTreeNode<CommandInterface>> inputTurtleList = input.getChildListAt(0);
		createTempActivleList(inputTurtleList,newActiveList );

		int range = 0;
		for (int j = 0; j < newActiveList.size(); j++) {
			range = newActiveList.get(j).intValue();
			int size = turtleData.turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}

			}

		}



			for (int i = 0; i < newActiveList.size(); i++) {
				turtleData.addToActiveList(newActiveList.get(i)-1 );

		}

		Double answer = 0.0;
		for (int i = 0; i < turtleData.activeTurtleListSize(); i++) {
			turtleData.setActiveTurtle(turtleData.activeTurtleListValue(i));
			turtleData.updateVariableMap(input.getCommandName(0, 1), (double) i);
			answer = traverser.traverse(input.getChildListAt(1), turtleData);
		}
		turtleData.setActiveTurtle(originalID);
		turtleData.clearActiveList();
		resetActiveList();
		return answer;
	}

}
