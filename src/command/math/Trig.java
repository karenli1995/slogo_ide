/**
 *
 */
package command.math;

import java.util.List;

import command.Command;
import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

/**
 *
 * @author Sally Al
 *
 */
public abstract class Trig extends Command {
	private static final int ANGLE = 90;

	@Override
	public Data execute(List<ParseTreeNode<Command>> angle, Data data, MathCommand mathcommand) {
		if (checkUnderfinedAngle(angle.get(0).getCommand().getValue())) {
			this.setValue(0);
		} else {

			this.setValue(evaluateAngle(Math.toRadians(angle.get(0).getCommand().getValue())));
		}
		return data;
	}

	private Boolean checkUnderfinedAngle(double angle) {
		return (angle % ANGLE == 0);
	}

	protected abstract double evaluateAngle(double angle);

}
