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
	private Data_Turtle_Interface turtleData;

	public Home(Data_Turtle_Interface turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> argument) {
		List<Double> defaultPosition = new ArrayList<Double>();
		defaultPosition.add(0.0);
		defaultPosition.add(0.0);
		turtleData.getTurtle(0).setRotationAngle(0.0);
		double distanceMoved= calculateDistanceBetweenTwoPoints(defaultPosition);
		this.setValue(distanceMoved);
		Point2D point = new Point2D(0.0, 0.0);
		addToTrail(point);
		return distanceMoved;
	}

}
