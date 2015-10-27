
package command.display.setters;

import command.display.Display;
import model.data.DisplayDataInterface;


/**
 *
 * @author Sally Al
 *
 */
public class SetBackground extends SetDisplayCommands {

  public SetBackground(DisplayDataInterface displayData) {
    super(displayData);
  }

  private static final long serialVersionUID = -2648763549594643733L;

  @Override
  public Display getEnum() {
    return Display.SETBG;
  }

}
