/**
 *
 */
package command.math.arithmetic;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Power extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1369755541702689606L;

	public Power() {
		super();
	}

	@Override
	public double execute(ParseTreeChildren number) {
		double power = Math.pow(number.getCommandValue(0,0), number.getCommandValue(1,0));
		this.setValue(power);
		return power;

	}

}
