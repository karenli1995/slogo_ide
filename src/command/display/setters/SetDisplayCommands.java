
package command.display.setters;

import command.display.Display;
import command.display.DisplayCommands;
import controller.ParseTreeChildren;
import model.data.DisplayDataInterface;


/**
 *
 * @author Sally Al
 *
 */
public abstract class SetDisplayCommands extends DisplayCommands {


	public SetDisplayCommands(DisplayDataInterface displayData) {
		super(displayData);
	}



	private static final long serialVersionUID = 5848226463121327563L;


    @Override
    public double execute (ParseTreeChildren input) {
        double value = input.getCommandValue(0, 0);
        setValue(value);
        putAndNotify(getEnum(), value);
        return value;

    }



    protected void putAndNotify (Display name, double value) {
        getMap().put(name, value);
        setChanged();
        notifyObservers();

    }

}
