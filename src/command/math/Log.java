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
		double log =Math.log(number.getCommandValue(0,0));
		this.setValue(log);
		return log;

	}

}
