package command.math.arithmetic;

import java.util.Arrays;
import java.util.List;
import command.Command;
import controller.ParseTreeChildren;


public class Sum extends UnlimitedInputCommand {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3214409066608523993L;

	public Sum () {
        super();
    }

    @Override
    public double execute (ParseTreeChildren arguments) {
      
        double sum = parameterLoop((list) -> list.stream().reduce((x,y) -> x+y).get() , arguments);
        this.setValue(sum);
        return sum;

    }

}
