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
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends TurtleAbsolutePosition {

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data, MathCommand mathcommand) {
		List<Double> defaultPosition = new ArrayList<Double>();
		defaultPosition.add(0.0);
		defaultPosition.add(0.0);
		data.getTurtle(0).setRotationAngle(0.0);
		this.setValue(calculateDistanceBetweenTwoPoints(defaultPosition, data));
		Point2D point = new Point2D(0.0, 0.0);
		addToTrail(data, point);
		return data;
	}

}
