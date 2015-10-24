package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.Data_Turtle_Interface;
import model.ForObserverInterface;

public class Repeat extends Command {
        Traverser traverse = new Traverser();
        private Data_Turtle_Interface turtleData;
        private ForObserverInterface errorData;
        
        public Repeat (Data_Turtle_Interface turtleData, ForObserverInterface errorData) {
            super(turtleData, errorData);
            this.turtleData = turtleData;
            this.errorData = errorData;
        }
        
        @Override
	public double execute(ParseTreeChildren distance) {
		int repeatTimes = (int) distance.getCommandValue(0, 0);
		double returnValue = (Double) null;
		for(int i = 0; i< repeatTimes; i++){
		    returnValue = traverse.traverse(distance.getChildListAt(1), errorData);
		}
		return returnValue;
	}
}
