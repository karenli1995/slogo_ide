
package command.display;

import command.Command;
import command.commandsObservers.DisplayCommandObserver;

/**
 *
 * @author Sally Al
 *
 */
public abstract class DisplayCommands extends Command {
	private static final DisplayCommandObserver observer = new DisplayCommandObserver();

	public DisplayCommands() {
		this.addObserver(observer);
	}

	private static final long serialVersionUID = -5049592034094334507L;

	public abstract Display getEnum();

}
