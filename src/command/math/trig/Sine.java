/**
 *
 */
package command.math.trig;

import command.Command;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class Sine extends Command {

    private static final long serialVersionUID = 6705493355876350144L;

    public Sine () {
    }

	/* (non-Javadoc)
	 * @see command.Command#execute(controller.ParseTreeChildren)
	 */
	@Override
	public double execute(ParseTreeChildren distance) {
		// TODO Auto-generated method stub
		return 0;
	}

 /*   @Override
    public double executeCommand (ParseTreeChildren argument) {
        double sine = Math.sin(Math.toRadians(argument.getCommandValue(0, 0)));
        sine = RoundTo2Decimals(sine);
        setValue(sine);
        return sine;
    }*/

}
