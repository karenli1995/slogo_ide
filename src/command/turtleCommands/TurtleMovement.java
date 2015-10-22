/**
 *
 */
package command.turtleCommands;

import java.text.DecimalFormat;
import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import model.Data_Turtle_Interface;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleMovement extends Command {
	private Data_Turtle_Interface data;

	public TurtleMovement(Data_Turtle_Interface allData) {
		data = allData;

	}

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> distance) {
		SlogoObjects currTurtle = data.getTurtle(0);
		// moveFdorBK(distance.get(0).getCommandValue(), currTurtle, data);
		moveFdorBK(distance.get(0).getCommandValue(), currTurtle);
		setValue(distance.get(0).getCommandValue());
		return distance.get(0).getCommandValue();

	}

	private double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	// public void moveFdorBK(double distance, SlogoObjects myTurtle, Data
	// myData) {
	public void moveFdorBK(double distance, SlogoObjects myTurtle) {
		int sign = getSign();

		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));
		// will re-factor this later
		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getTrail().getX();
		} else {
			tempXLocation = myTurtle.getTrail().getX() + ((sign) * distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation = (myTurtle.getTrail().getY());
		} else {
			tempYLocation = myTurtle.getTrail().getY() + (sign * (distance / Math.cos(radians)));
		}

		Point2D newLoc = new Point2D(tempXLocation, tempYLocation);

		myTurtle.getTrail().addCoord(newLoc);
		myTurtle.setTrail(myTurtle.getTrail());
		myTurtle.getTrail().setPoint(newLoc);
		myTurtle.setRotationAngle(degrees);

		data.setTurtle(0, myTurtle);
	}

	protected abstract int getSign();
}
