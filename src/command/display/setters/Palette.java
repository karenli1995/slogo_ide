
package command.display.setters;

import command.display.Display;

/**
 *
 * @author Sally Al
 *
 */
public class Palette extends SetDisplayCommands {

	private static final long serialVersionUID = 7026916684777044850L;

	@Override
	protected Display getEnum() {
		return Display.SETPALETTE;
	}

}
