
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.Data;


/**
 *
 * @author Sally Al
 *
 */
public class Power extends UnlimitedInputDoubleCommand {
    public Power (Data allData) {
        super(allData);
    }

    private static final long serialVersionUID = 1369755541702689606L;

    @Override
    public double execute (ParseTreeChildren argument) {
        double ans =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> Math.pow(x, y)).get(),
                               argument);
        setValue(ans);
        return ans;

    }

}
