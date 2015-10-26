
package command.display.setters;

import command.display.Display;
import model.data.DisplayDataInterface;


/**
 *
 * @author Sally Al
 *
 */
public class SetPenColor extends SetDisplayCommands {


	public SetPenColor(DisplayDataInterface displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = 5673442278693959109L;

    @Override
    public Display getEnum () {
        return Display.SETPC;
    }

}
