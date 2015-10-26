
package command.turtle.multiTurtle;

import java.util.ArrayList;
import java.util.List;
import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import model.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class Tell extends Command {
    private DataTurtleInterface turtleData;

    public Tell (DataTurtleInterface turtleData) {
        super(turtleData);
        this.turtleData = turtleData;
    }

    private static final long serialVersionUID = -477042076707708488L;

    @Override
	public double execute(ParseTreeChildren distance) {
	    List<ParseTreeNode<CommandInterface>> tempList = distance.getChildListAt(0);
	    List<Double> turtlesToWorkOn = new ArrayList<Double>();
	    for(int i = 1; i<tempList.size()-1; i++){
	        turtlesToWorkOn.add(tempList.get(i).getCommandValue());
	    }
	   
		Double range = turtlesToWorkOn.get(0);
		if (turtlesToWorkOn.size() == 1) {

			int size = turtleData.turtleListSize();
			if (range > size) {
				int diff = (int) (range - size);
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

    private void add (Double range) {
        for (int i = 0; i < range; i++) {
            turtleData.addToActiveList(i);
        }
    }

}
