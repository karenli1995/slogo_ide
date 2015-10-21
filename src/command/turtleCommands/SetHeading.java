/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class SetHeading extends CommandInterface {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> headingAngle, Data_Turtle_Interface data) {
		Double turtleCurrentHeading = data.getTurtle(0).getRotationAngle();
		Double delta = headingAngle.get(0).getCommand().getValue() - turtleCurrentHeading;
		data.getTurtle(0).setRotationAngle(turtleCurrentHeading + delta);
		this.setValue(delta);
		return data;
	}

}
