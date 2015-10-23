/**
 *
 */
package command.math;

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
		double diff = argument.get(0).get(0).getCommandValue() - argument.get(1).get(0).getCommandValue();
		this.setValue(diff);
		return diff;
	}

}
