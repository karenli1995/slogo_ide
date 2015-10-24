package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.Data;

public class Repeat extends Command {
        Traverser traverse = new Traverser();
        private Data allData;

        public Repeat (Data allData) {
            super(allData);
            this.allData =allData;
        }

        @Override
	public double execute(ParseTreeChildren distance) {
		int repeatTimes = (int) distance.getCommandValue(0, 0);
		double returnValue = 0.0;
		for(int i = 0; i< repeatTimes; i++){
		    returnValue = traverse.traverse(distance.getChildListAt(1), allData);
		}
		return returnValue;
	}
}
