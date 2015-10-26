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
public class Power extends UnlimitedInputCommand {
    public Power (Data allData) {
        super(allData);
    }


    /**
	 * 
	 */
	private static final long serialVersionUID = 1369755541702689606L;


	@Override
	public double execute(ParseTreeChildren argument) {
            double ans = parameterLoop((list) -> list.stream().reduce((x,y) -> Math.pow(x, y)).get() , argument);
            this.setValue(ans);
            return ans;

	}

}
