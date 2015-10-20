/**
 *
 */
package command.turtleCommands;

/**
 *
 * @author Sally Al
 *
 */
public class ShowTurtle extends TurtleVisibility {

	@Override
	protected Boolean visibility() {
		return true;
	}

	@Override
	protected double visibilityValue() {
		return 1;
	}

}
