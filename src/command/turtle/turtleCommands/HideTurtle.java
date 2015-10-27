
package command.turtle.turtleCommands;

import model.data.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class HideTurtle extends TurtleVisibility {

  /**
   *
   */
  private static final long serialVersionUID = -9141645305362865708L;

  public HideTurtle(DataTurtleInterface turtleData) {
    super(turtleData);
  }

  @Override
  protected Boolean visibility() {
    return false;
  }

  @Override
  protected double visibilityValue() {
    return 0;
  }

}
