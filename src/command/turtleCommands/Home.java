/**
 *
 */
package command.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import model.Data;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends Command {

	MoveTurtle moveTurtle = new MoveTurtle();

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		List<Double> defaultPosition = new ArrayList<Double>();
		defaultPosition.add(0.0);
		defaultPosition.add(0.0);
		this.setValue(moveTurtle.calculateDistanceBetweenTwoPoints(defaultPosition, data));
		/*Trail newLoc = new Trail(new Point2D(0.0, 0.0), 0.0);
		data.getTurtle(0).setTrail(newLoc);*/
		data.getTurtle(0).setRotationAngle(0.0);

		Trail loc = data.getTurtle(0).getTrail();
		loc.setPoint(new Point2D(0.0, 0.0));

		data.getTurtle(0).setTrail(loc);
		data.getTurtle(0).getTrail().addCoord(new Point2D(0.0, 0.0));
		return data;
	}

}
