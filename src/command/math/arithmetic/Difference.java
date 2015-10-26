/**
 *
 */
package command.math.arithmetic;

import command.Command;
import command.otherCommands.UnlimitedInputCommand;
import controller.ParseTreeChildren;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Difference extends UnlimitedInputCommand {
    public Difference (Data allData) {
        super(allData);
    }


    /**
	 * 
	 */
	private static final long serialVersionUID = -7357237139931369565L;


	@Override
	public double execute(ParseTreeChildren argument) {
	        double ans = parameterLoop((list) -> list.stream().reduce((x,y) -> x-y).get() , argument);
	        this.setValue(ans);
	        return ans;
	}

}
