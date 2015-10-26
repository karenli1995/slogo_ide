
package command.display.setters;

import command.display.Display;


/**
 *
 * @author Sally Al
 *
 */
public class SetPenColor extends SetDisplayCommands {

    private static final long serialVersionUID = 5673442278693959109L;

    @Override
    protected Display getEnum () {
        return Display.SETPC;
    }

}
