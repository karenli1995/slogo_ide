/**
 *
 */
package display;

import java.util.HashMap;
import java.util.Map;

import command.Command;

/**
 *
 * @author Sally Al
 *
 */
public abstract class DisplayCommands extends Command{

	protected static Map<Display, Double> map = new HashMap<Display, Double>();
	protected void putAndNotify(Display name, double value){
		map.put(name, value);
		//not sure about this yet
		setChanged();
		notifyObservers();

	}



}
