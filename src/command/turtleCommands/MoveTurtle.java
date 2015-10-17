/**
 *
 */
package command.turtleCommands;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import model.Data;
import model.Location;
import model.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public class MoveTurtle {
	private List<Double> linePoints = new ArrayList<Double>();

	private static final int lineStartX = 0;
	private static final int lineEndX = 2;
	private static final int lineStartY = 1;
	private static final int lineEndY = 3;

	double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	public void moveFdorBK(double distance, int sign, SlogoObjects myTurtle) {

		linePoints.add(lineStartX, myTurtle.getLocation().getX());
		linePoints.add(lineStartY, myTurtle.getLocation().getY());

		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));

		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getLocation().getX();
		} else {
			tempXLocation = myTurtle.getLocation().getX() + (-(sign) * distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation = (myTurtle.getLocation().getX());
		} else {
			tempYLocation = myTurtle.getLocation().getY() + (sign * (distance / Math.cos(radians)));
		}

		Location newLoc = new Location(new Point2D(tempXLocation, tempYLocation), degrees);
		myTurtle.setLocation(newLoc);

		linePoints.add(lineEndX, myTurtle.getLocation().getX());
		linePoints.add(lineEndY, myTurtle.getLocation().getY());

	}

	public double calculateDistanceBetweenTwoPoints(List<Double> newLocation, Data data) {

		double x1 = data.getTurtle(0).getLocation().getX();
		double y1 = data.getTurtle(0).getLocation().getY();
		double x2 = newLocation.get(0);// + turtleScene.getCentrex();
		double y2 = newLocation.get(1);// + turtleScene.getCentrey();

		linePoints.add(lineStartX, x1);
		linePoints.add(lineStartY, y1);
		linePoints.add(lineEndX, x2);
		linePoints.add(lineEndY, y2);

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		data.getTurtle(0).getLocation().setX(x2);
		data.getTurtle(0).getLocation().setY(y2);

		return distance;
	}

	public List<Double> getLinePoints() {
		return linePoints;
	}

}
