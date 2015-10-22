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
	public Atan(){
		super();
	}
	@Override
	protected double evaluateAngle(double angle) {
		return (Math.atan(angle));
	}



}
