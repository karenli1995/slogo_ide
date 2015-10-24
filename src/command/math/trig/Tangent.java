/**
 *
 */
package command.math.trig;

/**
 *
 * @author Sally Al
 *
 */
public class Tangent extends Trig {

	@Override
	protected double evaluateAngle(double angle) {
		return (Math.tan(angle));
	}

}
