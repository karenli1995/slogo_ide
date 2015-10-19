/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class SetHeading extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> headingAngle, Data data) {
		Double turtleCurrentHeading = data.getTurtle(0).getRotationAngle();
		Double delta = headingAngle.get(0).getCommand().getValue() - turtleCurrentHeading;
		data.getTurtle(0).setRotationAngle(turtleCurrentHeading + delta);
		this.setValue(delta);
		return data;
	}

}
