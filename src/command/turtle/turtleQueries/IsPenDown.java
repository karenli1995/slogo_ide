
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class IsPenDown extends TurtleCommands {

  private static final long serialVersionUID = 7464805867540834237L;

  public IsPenDown(DataTurtleInterface data) {
    super(data);

  }

  @Override
  public double executeCommand(ParseTreeChildren distance) {
    double flag = getTurtle().getPen().isDown();
    setValue(flag);
    return flag;
  }

}
