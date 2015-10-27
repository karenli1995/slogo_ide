
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleVisibility extends Command {

  private static final long serialVersionUID = 4129734871347895441L;
  private DataTurtleInterface data;

  public TurtleVisibility(DataTurtleInterface turtleData) {
    super(turtleData);
    data = turtleData;
  }

  @Override
  public double execute(ParseTreeChildren angle) {
    data.getTurtle(0).setIsShowing(visibility());
    setValue(visibilityValue());
    return visibilityValue();

  }

  protected abstract Boolean visibility();

  protected abstract double visibilityValue();

}
