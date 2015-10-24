package command.nullConstructor;

import command.Command;
import controller.ParseTreeChildren;

public class Variable  extends Command {


public Variable() {
	super();

}

	@Override
	public double execute(ParseTreeChildren argument) {


System.out.println("SDSD");
	/*	String varName = argument.get(0).getCommand().getName();
		Double value = argument.get(1).getCommand().getValue();
		data.updateVaraibleMap(varName, value);
		System.out.println(data.getVariableMap().size());
*/
		return 0;
	}


}
