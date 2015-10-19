/**
 *
 */
package command.math;

/**
 *
 * @author Sally Al
 *
 */
public class Atan extends Trig {

	@Override
	protected double evaluateAngle(double angle) {
		return (Math.atan(angle));
	}

}
