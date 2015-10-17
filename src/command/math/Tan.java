/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Tan extends Command {

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data) {
		if (angle.get(0).getCommand().getValue() % 90 == 0) {
			this.setValue(0);
		} else {
			this.setValue(Math.tan(Math.toRadians(angle.get(0).getCommand().getValue())));
		}
		return data;
	}

}
