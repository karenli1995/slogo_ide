package command.syntax;

import command.Command;
import controller.ParseTreeChildren;
import model.data.DataTurtleInterface;


public class Constant extends Command {

  private static final long serialVersionUID = -4748693328683228805L;
  DataTurtleInterface data;

  public Constant() {
  }

  public Constant(DataTurtleInterface s) {
    super(s);
    data = s;
  }

  @Override
  public double execute(ParseTreeChildren argument) {
    return 0;
  }

}
