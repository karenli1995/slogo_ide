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
public class Or extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 6117760367645332523L;

    @Override
    public double execute (ParseTreeChildren argument) {
        if ((argument.getCommandValue(0, 0) == 0 && argument.getCommandValue(1, 0) == 0)) {
            setValue(0);
            return 0;
        }
        else {
            setValue(1);
            return 1.0;
        }

    }

}
