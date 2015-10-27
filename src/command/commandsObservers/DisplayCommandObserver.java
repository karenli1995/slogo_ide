
package command.commandsObservers;

import java.io.Serializable;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import command.display.Display;
import command.display.DisplayCommands;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public class DisplayCommandObserver implements Observer,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3904275080077140560L;
	Data data;
	public DisplayCommandObserver(Data data){
		this.data= data;
	}
	@Override
	public void update(Observable o, Object arg) {

		DisplayCommands observedClass = (DisplayCommands) o;
		Map<Display, Double> map=observedClass.getMap();
		if(map.get(Display.SETBG)!=null){
			//put the method/variable here
			//map key is enum and value is double
		}


		}


	}


