/**
 *
 */
package command.booleanOperations;

import java.util.Comparator;

/**
 *
 * @author Sally Al
 *
 */
public class BooleanOperations implements Comparator<Integer>{


	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0 > arg1) {
			return 1;
		} else if (arg0 < arg1) {
			return -1;
		} else {
			return 0;
		}
	}

}
