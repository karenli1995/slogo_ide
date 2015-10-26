
package command.turtle.multiTurtle;

import java.util.List;

import command.Command;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class Tell extends Command {
	private DataTurtleInterface turtleData;

	public Tell(DataTurtleInterface turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	private static final long serialVersionUID = -477042076707708488L;

	@Override
	public double execute(ParseTreeChildren distance) {

		List<Integer> turtlesToworkOn = null;//kevin what should i put here to get [100] or [1 2 3]
		int range = 0;
		for(int j = 0 ; j <turtlesToworkOn.size(); j++ ) {
			range=turtlesToworkOn.get(j);
			int size = turtleData.turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}
				add(range);

			} else {
				add(range);
			}
		}
		return range - 1;
	}

	private void add(int range) {
		for (int i = 0; i < range; i++) {
			turtleData.addToActiveList(i);
		}
	}

}
