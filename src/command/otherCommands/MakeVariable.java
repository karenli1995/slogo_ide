package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.data.Data;


public class MakeVariable extends Command {

  /**
   *
   */
  private static final long serialVersionUID = 3131529990290290269L;
  private Data allData;

  public MakeVariable(Data data) {
    super(data);
    allData = data;
  }

  @Override
  public double execute(ParseTreeChildren argument) {

    String varName = argument.getCommandName(0, 0);
    Double value = argument.getCommandValue(1, 0);
    allData.updateVariableMap(varName, value);
    return value;
  }

}
