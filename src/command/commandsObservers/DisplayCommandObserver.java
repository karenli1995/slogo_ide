
package command.commandsObservers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import command.display.Display;
import command.display.DisplayCommands;
import javafx.scene.paint.Color;
import model.data.Data;
import view.settings.SlogoProperties;

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
	private ArrayList<String> myColors = SlogoProperties.getColorArray();
	public DisplayCommandObserver(Data data){
		this.data= data;
	}
	@Override
	public void update(Observable o, Object arg) {

		DisplayCommands observedClass = (DisplayCommands) o;
		Map<Display, List<Double>> map=observedClass.getMap();
		if(map.get(Display.SETBG)!=null){
			//put the method/variable here
			//map key is enum and value is double
			data.setMyColor(Color.web(myColors.get(map.get(Display.SETBG).get(0).intValue())));
		}


		}


	}


