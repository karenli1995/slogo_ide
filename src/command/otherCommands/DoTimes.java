package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.Data_Turtle_Interface;
import model.ForObserverInterface;


public class DoTimes extends Command {
    private Data_Turtle_Interface turtleData;
    private ForObserverInterface errorData;
    Traverser traverser = new Traverser();

    public DoTimes (Data_Turtle_Interface turtleData, ForObserverInterface errorData) {
        super(turtleData, errorData);
        this.turtleData = turtleData;
        this.errorData = errorData;
    }

    @Override
    public double execute (ParseTreeChildren list) {
        int range = (int) list.getCommandValue(0, 0);
        for (double i = 1; i < range + 1; i++) {
            turtleData.updateVaraibleMap(list.getCommandName(0, 0), i);
            traverser.traverse(list.getChildListAt(1), errorData);
        }
        return 0.0;
    }

}
