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
public class Difference extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7357237139931369565L;

	public Difference(){
		super();
	}

	@Override
	public double execute(ParseTreeChildren argument) {
		double diff = argument.getCommandValue(0,0) - argument.getCommandValue(1,0);
		this.setValue(diff);
		return diff;
	}

}
