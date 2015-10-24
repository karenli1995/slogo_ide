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
public class Remainder extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5675238179764860997L;

	@Override
	public double execute(ParseTreeChildren argument) {
		double remainder = argument.getCommandValue(0,0) % argument.getCommandValue(1,0);
		this.setValue(remainder);
		return remainder;
	}

}
