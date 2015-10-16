/**
 *
 */
package command.turtleQueries;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import view.TurtleScene;

/**
 *
 * @author Sally Al
 *
 */
public class YCOR extends Command {
	private static TurtleScene turtleScene = new TurtleScene();

	@Override
	public Data execute(List<ParseTreeNode<Command>> distance, Data data) {
		distance.clear();
		double y = data.getTurtle(0).getMyImage().getLayoutY() - turtleScene.getCentrey();
		this.setValue(y);
		return data;
	}

}
