package command.turtleCommands;

import model.Data;

public class Forward extends TurtleMovement {


	public Forward(Data data) {
		super(data);
	}

	@Override
	protected int getSign() {
		return 1;
	}



}
