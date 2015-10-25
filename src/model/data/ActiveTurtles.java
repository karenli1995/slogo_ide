package model.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sally Al
 *
 */
public class ActiveTurtles {

	private static List<Integer> activeTurtles;

	// no modifier = default = only from package
	ActiveTurtles() {
		activeTurtles = new ArrayList<Integer>();
		activeTurtles.add(0);

	}

	public void update(List<Integer> activeTobe) {
		for (int i = 0; i < activeTobe.size(); i++) {
			if (activeTurtles.contains(activeTobe.get(i)) == false)
				activeTurtles.add(activeTobe.get(i));
		}

	}

	public int size() {
		return activeTurtles.size();
	}

	public int getvalue(int index) {
		if (index < activeTurtles.size()) {
			return activeTurtles.get(index);
		} else {
			return 0;
		}
	}
}
