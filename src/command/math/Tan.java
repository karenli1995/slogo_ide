/**
 *
 */
package command.math;

/**
 *
 * @author Sally Al
 *
 */
public class Tan extends Trig {

	@Override
	protected double evaluateAngle(double angle) {
		return (Math.tan(angle));
	}

}
