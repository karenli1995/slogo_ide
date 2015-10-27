
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class ID extends TurtleCommands {

  private static final long serialVersionUID = 3565943439758546699L;
  DataTurtleInterface turtleData;

  public ID(DataTurtleInterface turtleData) {
    super(turtleData);
    this.turtleData = turtleData;
  }

  @Override
  public double executeCommand(ParseTreeChildren distance) {
    setValue(turtleData.getActiveTurtleID());
    return turtleData.getActiveTurtleID();
  }

}
