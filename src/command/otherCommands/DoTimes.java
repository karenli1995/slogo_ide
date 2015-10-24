package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.Data;
import model.Data_Turtle_Interface;

public class DoTimes extends Command {
	private Data_Turtle_Interface turtleData;
	private Data allData;

	public DoTimes(Data_Turtle_Interface turtleData, Data data) {
		super(data);
		this.turtleData = turtleData;
		this.allData=data;
	}

	@Override
	public double execute(ParseTreeChildren list) {
		Traverser traverser = new Traverser();
		int range = (int) list.getCommandValue(0, 0);
		for (double i = 0; i < range; i++) {
			turtleData.updateVaraibleMap(list.getCommandName(0, 0), i);
			traverser.traverse(list.getChildListAt(1),allData );
		}
		return 0.0;
	}

}
