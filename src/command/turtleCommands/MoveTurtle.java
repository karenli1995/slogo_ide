/**
 *
 */
package command.turtleCommands;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import model.Data;
import view.TurtleScene;

/**
 *
 * @author Sally Al
 *
 */
public class MoveTurtle {
	private List<Double> linePoints = new ArrayList<Double>();
	private static TurtleScene turtleScene = new TurtleScene();

	private static final int lineStartX = 0;
	private static final int lineEndX = 1;
	private static final int lineStartY = 2;
	private static final int lineEndY = 3;

	double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	public void moveFdorBK(double distance, int sign, ImageView myTurtle) {

		linePoints.add(lineStartX, myTurtle.getLayoutX());
		linePoints.add(lineStartY, myTurtle.getLayoutY());

		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotate();
		double radians = Math.toRadians(degrees);

		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));

		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getLayoutX();
		} else {
			tempXLocation = myTurtle.getLayoutX() + (-(sign) * distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation = (myTurtle.getLayoutY());
		} else {
			tempYLocation = myTurtle.getLayoutY() + (sign * (distance / Math.cos(radians)));
		}

		myTurtle.setLayoutX(tempXLocation);
		myTurtle.setLayoutY(tempYLocation);

		linePoints.add(lineEndX, myTurtle.getLayoutX());
		linePoints.add(lineEndY, myTurtle.getLayoutY());

	}

	public double calculateDistanceBetweenTwoPoints(List<Double> newLocation, Data data) {

		double x1 = data.getTurtle(0).getMyImage().getLayoutX();
		double y1 = data.getTurtle(0).getMyImage().getLayoutY();
		double x2 = newLocation.get(0) + turtleScene.getCentrex();
		double y2 = newLocation.get(1) + turtleScene.getCentrey();

		linePoints.add(lineStartX, x1);
		linePoints.add(lineStartY, y1);
		linePoints.add(lineEndX, x2);
		linePoints.add(lineEndY, y2);

		double distance = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
		distance = Math.sqrt(distance);

		data.getTurtle(0).getMyImage().setLayoutX(x2);
		data.getTurtle(0).getMyImage().setLayoutY(y2);

		return distance;
	}

	public List<Double> getLinePoints() {
		return linePoints;
	}

}
