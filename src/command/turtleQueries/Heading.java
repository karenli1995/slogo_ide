/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Heading extends Command {
	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		this.setValue(data.getTurtle(0).getRotationAngle());
		System.out.println(data.getTurtle(0).getRotationAngle());
		return data;
	}

}
