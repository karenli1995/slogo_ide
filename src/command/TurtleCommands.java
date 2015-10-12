/**
 *
 */
package command;

import javafx.scene.image.ImageView;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleCommands extends Command {
ImageView turtle;
	public TurtleCommands() {

	}

	public void setTurtle(ImageView turtle){
		this.turtle=turtle;
	};
	public ImageView getTurtle(){return turtle;}

}
