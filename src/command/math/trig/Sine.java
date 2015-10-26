/**
 *
 */
package command.math.trig;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class Sine extends TurtleCommands {

    private static final long serialVersionUID = 6705493355876350144L;

    public Sine () {
    }

    @Override
    public double executeCommand (ParseTreeChildren argument) {
        double sine = Math.sin(Math.toRadians(argument.getCommandValue(0, 0)));
        sine = RoundTo2Decimals(sine);
        setValue(sine);
        return sine;
    }

}
