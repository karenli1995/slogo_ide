/**
 *
 */
package command.booleanOperations;

import java.util.List;
import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.Data;


/**
 *
 * @author Sally Al
 *
 */
public class Or extends UnlimitedInputDoubleCommand {
    /**
     *
     */
    private static final long serialVersionUID = 6933861121473227309L;

    public Or (Data allData) {
        super(allData);
    }

    @Override
    public double execute (ParseTreeChildren argument) {

        double value =
                parameterLoop( (list) -> logic(list), argument);
        setValue(value);
        return value;

    }

    public double logic (List<Double> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                return 1;
            }
        }
        return 0;

    }

}
