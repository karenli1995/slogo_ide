/**
 *
 */
package command.turtleCommands;

import java.text.DecimalFormat;

import javafx.scene.image.ImageView;

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

	public void execute(double distance, int sign, ImageView myTurtle) {
		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotate();









		double radians = Math.toRadians(degrees);
		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));
		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getLayoutX();
		} else {
			tempXLocation = myTurtle.getLayoutX() + (-(sign)*distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation=(myTurtle.getLayoutY());
		} else {
			tempYLocation = myTurtle.getLayoutY() + (sign*(distance / Math.cos(radians)));
		}
		myTurtle.setLayoutX(tempXLocation);
		myTurtle.setLayoutY(tempYLocation);
	}

}
