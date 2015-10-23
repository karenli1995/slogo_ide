package command.turtle.turtleCommands;

import model.Data_Turtle_Interface;

public class Forward extends TurtleMovement {


	public Forward(Data_Turtle_Interface data) {
		super(data);
	}

	@Override
	protected int getSign() {
		return 1;
	}





}
