
package command.display.setters;

import java.util.ArrayList;
import java.util.List;

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
        List<Double> list = new ArrayList<Double>();
        double value = input.getCommandValue(0, 0);
        setValue(value);
    	for(int i = 0; i<input.getSize(); i++){
        list.add(input.getCommandValue(i, 0));
        }
        putAndNotify(getEnum(), list);
        return value;

    }



    protected void putAndNotify (Display name, List<Double> value) {
        getMap().put(name, value);
        setChanged();
        notifyObservers();

    }

}
