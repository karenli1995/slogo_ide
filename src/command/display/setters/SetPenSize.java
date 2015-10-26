
package command.display.setters;

import command.display.Display;
import model.data.DisplayDataInterface;


/**
 *
 * @author Sally Al
 *
 */
public class SetPenSize extends SetDisplayCommands {


	public SetPenSize(DisplayDataInterface displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = -7187401381565709898L;

    @Override
    public Display getEnum () {
        return Display.SETPS;
    }

}
