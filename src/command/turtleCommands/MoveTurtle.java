/**
 *
 */
package command.turtleCommands;

import java.text.DecimalFormat;
import java.util.List;

import javafx.geometry.Point2D;
import model.Data;
import model.SlogoObjects;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public class MoveTurtle {


	double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	public void moveFdorBK(double distance, int sign, SlogoObjects myTurtle) {

		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));

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

		Trail newLoc = new Trail(new Point2D(tempXLocation, tempYLocation), degrees);

		myTurtle.setTrail(newLoc);
		myTurtle.getTrail().addCoord(new Point2D(tempXLocation, tempYLocation));

	}

	public double calculateDistanceBetweenTwoPoints(List<Double> newLocation, Data data) {

		double x1 = data.getTurtle(0).getTrail().getX();
		double y1 = data.getTurtle(0).getTrail().getY();
		double x2 = newLocation.get(0);// + turtleScene.getCentrex();
		double y2 = newLocation.get(1);// + turtleScene.getCentrey();

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

//		data.getTurtle(0).getTrail().setX(x2);
//		data.getTurtle(0).getTrail().setY(y2);

		data.getTurtle(0).getTrail().addCoord(new Point2D(x2, y2));

		return distance;
	}

}
