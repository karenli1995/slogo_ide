package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Sally Al
 *
 */
public class ActiveTurtles implements Serializable {

    private static List<Integer> activeTurtles;

    protected ActiveTurtles () {
        activeTurtles = new ArrayList<Integer>();
        activeTurtles.add(0);

    }

    public void update (int activeTobe) {

        if (activeTurtles.contains(activeTobe) == false) {
            activeTurtles.add(activeTobe);

        }
    }

    public int size () {
        return activeTurtles.size();
    }

    public void remove(int index){
    	activeTurtles.remove(index);
    }

    public int getvalue (int index) {
        if (index < activeTurtles.size()) {
            return activeTurtles.get(index);
        }
        else {
            return 0;
        }
    }
}
