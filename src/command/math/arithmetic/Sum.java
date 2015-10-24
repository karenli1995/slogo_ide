package command.math.arithmetic;

import command.Command;
import controller.ParseTreeChildren;


public class Sum extends Command {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3214409066608523993L;

	public Sum () {
        super();
    }

    @Override
    public double execute (ParseTreeChildren arguments) {

        double sum = arguments.getCommandValue(0, 0) + arguments.getCommandValue(1, 0);
        this.setValue(sum);
        return sum;

    }

}
