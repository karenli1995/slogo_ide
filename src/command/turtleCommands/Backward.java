/**
 *
 */
package command.turtleCommands;

import java.util.List;

import command.Command;
import javafx.scene.image.ImageView;

/**
 *
 * @author Sally Al
 *
 */
public class Backward extends Command{

	private ImageView myTurtle;
	@Override
	public double execute(List<Double> distance) {

		MoveTurtle moveTurtle = new MoveTurtle();
		moveTurtle.execute(distance.get(0), 1, myTurtle);
		 return distance.get(0);
	}

	public void makeTurtle(ImageView myImage) {
		myTurtle = myImage;

	}

}
