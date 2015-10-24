/**
 *
 */
package command.booleanOperations;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Greater extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8827586110836348387L;

	@Override
	public double execute(ParseTreeChildren argument) {
		System.out.println("abc");
		if (argument.getCommandValue(0,0) > argument.getCommandValue(1,0)) {
			System.out.println("ddd"+argument.getCommandValue(0,0));
			this.setValue(1.0);
			return 1.0;
		} else {
			System.out.println("xyz");
			this.setValue(0);
			return 0;
		}

	}

}
