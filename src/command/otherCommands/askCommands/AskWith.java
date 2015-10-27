
package command.otherCommands.askCommands;

import java.util.ArrayList;
import java.util.List;

import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public class AskWith extends MultiCommands {

	private static final long serialVersionUID = 4138964378710412366L;
	private Data data;
	private Traverser traverser = new Traverser();

	public AskWith(Data turtleData) {
		super(turtleData);
		this.data = turtleData;
	}

	@Override
	public double execute(ParseTreeChildren input) {

		List<Integer> activeToBe = new ArrayList<Integer>();

		for (int i = 0; i < data.turtleListSize(); i++) {
			data.updateVariableMap(input.getCommandName(0, 1), (double) i);
			double answer = traverser.traverse(input.getChildListAt(0), data);
			if (answer == 1.0) {
				activeToBe.add(i);

			}
		}

		backUpActive();
		// this method is important because this is the list that the commands
		// actually use
		for (int i = 0; i < activeToBe.size(); i++) {
			turtleData.addToActiveList(activeToBe.get(i));

		}

		int range = 0;
		for (int j = 0; j < activeToBe.size(); j++) {
			range = activeToBe.get(j).intValue();
			int size = turtleData.turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}

			}

		}

		double answer = 4.0;
		for (int i = 0; i < activeToBe.size(); i++) {
			turtleData.setActiveTurtle(i);
			// turtleData.updateVariableMap(input.getCommandName(0, 1), (double)
			// i);
			answer = traverser.traverse(input.getChildListAt(1), turtleData);
		}
		turtleData.setActiveTurtle(originalID);
		turtleData.clearActiveList();
		resetActiveList();
		return answer;
	}

}
