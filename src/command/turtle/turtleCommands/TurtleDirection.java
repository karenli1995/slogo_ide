/**
 *
 */
package command.turtle.turtleCommands;

import command.TurtleCommands;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends TurtleCommands {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4365978061345276670L;
	private DataTurtleInterface turtleData;

	public TurtleDirection(DataTurtleInterface data) {
		turtleData = data;
	}

	protected abstract int sign();

	@Override
	public double execute(ParseTreeChildren angle) {
		double angleValue = angle.getCommandValue(0, 0);
		double newHeadAngle = turtleData.getTurtle(0).getRotationAngle() + ((sign()) * angleValue);
		this.setValue(angleValue);
		updateLocation(getCurrX(), getCurrY(), newHeadAngle);
		return angleValue;
	}

	private double getCurrX() {
		return turtleData.getTurtle(0).getTrail().getX();
	}

	private double getCurrY() {
		return turtleData.getTurtle(0).getTrail().getY();
	}

}
