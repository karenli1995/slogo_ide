
package command.display;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import model.data.DisplayDataInterface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class DisplayCommands extends Command {

    private static Map<Display, Double> map = new HashMap<Display, Double>();

	public DisplayCommands( DisplayDataInterface displayData) {
		this.addObserver(displayData.getDisplayCommandsObserver());
	}

	private static final long serialVersionUID = -5049592034094334507L;

	public abstract Display getEnum();

	public static Map<Display, Double> getMap() {
		return map;
	}

	public static void setMap(Map<Display, Double> map) {
		DisplayCommands.map = map;
	}

}
