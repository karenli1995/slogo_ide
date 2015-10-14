package command.turtleCommands;

import java.util.List;

import command.Command;
import model.Data;

public class Forward extends Command {

	@Override
	public double execute(List<Double> distance, Data data) {

		MoveTurtle moveTurtle = new MoveTurtle();
		moveTurtle.moveFdorBK(distance.get(0), -1, data.getTurtle(0).getMyImage());
		return distance.get(0);

	}

}
