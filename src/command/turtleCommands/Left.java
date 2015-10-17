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
public class Left extends Command {


	@Override
	public Data execute(List<ParseTreeNode<Command>> angle,Data data) {
		double newHeadAngle=data.getTurtle(0).getMyImage().getRotate()-angle.get(0).getCommand().getValue();
		data.getTurtle(0).getMyImage().setRotate(newHeadAngle);
		data.getTurtle(0).setMyHeadAngle(newHeadAngle);
		this.setValue(angle.get(0).getCommand().getValue());
		return data;
	}


}
