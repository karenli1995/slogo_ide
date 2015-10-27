package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.Data;


public class If extends Command {
  /**
  *
  */
  private static final long serialVersionUID = 1269907837457610038L;
  private Data allData;
  Traverser traverser = new Traverser();

  public If(Data allData) {
    super(allData);
    this.allData = allData;
  }

  @Override
  public double execute(ParseTreeChildren distance) {
    double ans = 0;
    if (distance.getCommandValue(0, 0) != 0) {
      ans = traverser.traverse(distance.getChildListAt(1), allData);
    }
    return ans;
  }

}
