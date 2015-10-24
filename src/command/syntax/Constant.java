package command.syntax;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

public class Constant extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4748693328683228805L;
	Data_Turtle_Interface data;

	public Constant() {
	}

	public Constant(Data_Turtle_Interface s) {
		super(s);
		data = s;
	}

	@Override
	public double execute(ParseTreeChildren argument) {
		return 0;
	}

}
