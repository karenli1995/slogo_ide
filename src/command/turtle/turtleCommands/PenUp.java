
package command.turtle.turtleCommands;

import model.data.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class PenUp extends PenCommands {

  private static final long serialVersionUID = 1082991179374772194L;

  public PenUp(DataTurtleInterface turtleData) {
    super(turtleData);
  }

  @Override
  protected double switchPen() {
    return 0;
  }

}
