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
public class Cos extends Command {
	public Cos(){
		super();
	}
	@Override
	public double execute(ParseTreeChildren argument) {
		double cosangle=Math.cos(Math.toRadians(argument.get(0).get(0).getCommandValue()));
		this.setValue(cosangle);
		return cosangle;
	}

}
