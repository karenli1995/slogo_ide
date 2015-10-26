
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class ID extends TurtleCommands{

	private static final long serialVersionUID = 3565943439758546699L;
	DataTurtleInterface turtleData;
public ID (DataTurtleInterface turtleData){
	super(turtleData);
	this.turtleData=turtleData;
}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		return turtleData.getActiveTurtleID();
	}

}
