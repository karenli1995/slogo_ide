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
public class Right extends Command {

	private ImageView myTurtle;

	public void makeTurtle(ImageView myImage) {
		myTurtle = myImage;

	}


	@Override
	public double execute(List<Double> angle) {
		myTurtle.setRotate(myTurtle.getRotate()+angle.get(0));
		return angle.get(0);
	}


}
