
package command.display.setters;

import java.util.HashMap;
import java.util.Map;
import command.display.Display;
import command.display.DisplayCommands;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public abstract class SetDisplayCommands extends DisplayCommands {

    private static final long serialVersionUID = 5848226463121327563L;

    protected static Map<Display, Double> map = new HashMap<Display, Double>();

    @Override
    public double execute (ParseTreeChildren input) {
        double value = input.getCommandValue(0, 0);
        setValue(value);
        putAndNotify(getEnum(), value);
        return value;

    }

    protected abstract Display getEnum ();

    protected void putAndNotify (Display name, double value) {
        map.put(name, value);
        // not sure about this yet
        setChanged();
        notifyObservers();

    }

}
