/**
 *
 */
package command.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends Command {

	MoveTurtle moveTurtle= new MoveTurtle();
	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
	List<Double> defaultPosition= new ArrayList<Double>();
	defaultPosition.add(0.0);
	defaultPosition.add(0.0);
		this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(defaultPosition, data));
		return data;
	}

}
