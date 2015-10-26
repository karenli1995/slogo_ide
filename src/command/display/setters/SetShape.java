
package command.display.setters;

import command.display.Display;
import model.data.DisplayDataInterface;


/**
 *
 * @author Sally Al
 *
 */
public class SetShape extends SetDisplayCommands {


	public SetShape(DisplayDataInterface displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = 5765949474471118329L;

    @Override
    public Display getEnum () {
        return Display.SETSH;
    }

}
