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
