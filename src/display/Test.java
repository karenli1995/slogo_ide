
package display;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Test extends Command{

	private static final long serialVersionUID = 7874189450806050411L;

	@Override
	public double execute(ParseTreeChildren distance) {
		Map<Display, Integer> map = new HashMap<Display, Integer>();
		for (Display level : Display.values()) {
			map.put(level, 2);
		}
		return 0;
	}

}
