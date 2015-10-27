package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.Data;


public class For extends Command {

  private static final long serialVersionUID = -1709915109882273600L;
  private Data allData;
  Traverser traverser = new Traverser();

  public For(Data allData) {
    super(allData);
    this.allData = allData;
  }

  @Override
  public double execute(ParseTreeChildren list) {
    int start = (int) list.getCommandValue(0, 2);
    int end = (int) list.getCommandValue(0, 3);
    int increment = (int) list.getCommandValue(0, 4);
    String variable = list.getCommandName(0, 1);
    double ans = 0;
    for (double i = start; i < end + increment; i = i + increment) {
      allData.updateVariableMap(variable, i);
      ans = traverser.traverse(list.getChildListAt(1), allData);
    }
    return ans;
  }

}
