
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public class ID extends TurtleCommands{
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
