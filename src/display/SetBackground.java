
package display;

import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class SetBackground extends DisplayCommands {

	private static final long serialVersionUID = -2648763549594643733L;
	private static final Display SETBG = Display.SETBG;

	@Override
	public double execute(ParseTreeChildren input) {
		double value = input.getCommandValue(0, 0);
		this.setValue(value);
		putAndNotify(SETBG, value);
		return value;


	}

}
