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
public class Log extends Command {
	public Log(){
		super();
	}

	@Override
	public double execute(ParseTreeChildren number) {
		double log =Math.log10(number.get(0).get(0).getCommandValue());
		this.setValue(log);
		return log;

	}

}
