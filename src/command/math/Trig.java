/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public abstract class Trig extends Command {
	private static final int ANGLE = 90;

	@Override
	public double execute(List<ParseTreeNode<CommandInterface>> angle) {
		if (checkUnderfinedAngle(angle.get(0).getCommand().getValue())) {
			this.setValue(0);
		} else {

			this.setValue(evaluateAngle(Math.toRadians(angle.get(0).getCommand().getValue())));
		}
		return this.getValue();

	}

	private Boolean checkUnderfinedAngle(double angle) {
		return (angle % ANGLE == 0);
	}

	protected abstract double evaluateAngle(double angle);

}
