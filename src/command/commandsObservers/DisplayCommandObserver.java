
package command.commandsObservers;

import java.util.Observable;
import java.util.Observer;

import command.display.DisplayCommands;

/**
 *
 * @author Sally Al
 *
 */
public class DisplayCommandObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {

		DisplayCommands observedClass = (DisplayCommands) o;
		System.out.println(observedClass.getEnum().SETBG);


	}

}
