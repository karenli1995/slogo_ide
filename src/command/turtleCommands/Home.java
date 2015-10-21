/**
 *
 */
package command.turtleCommands;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class Home extends TurtleAbsolutePosition {

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> argument, Data_Turtle_Interface data) {
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
