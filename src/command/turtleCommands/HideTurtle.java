/**
 *
 */
package command.turtleCommands;

/**
 *
 * @author Sally Al
 *
 */
public class HideTurtle extends TurtleVisibility {

	@Override
	protected Boolean visibility() {
		return false;
	}

	@Override
	protected double visibilityValue() {
		return 0;
	}

}
