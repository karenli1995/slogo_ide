package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.Data;


public class DoTimes extends Command {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1709915109882273600L;
	private Data allData;
    Traverser traverser = new Traverser();

    public DoTimes (Data allData) {
        super(allData);
        this.allData= allData;
    }

    @Override
    public double execute (ParseTreeChildren list) {
        int range = (int) list.getCommandValue(0, 0);
        for (double i = 1; i < range + 1; i++) {
        	allData.updateVaraibleMap(list.getCommandName(0, 0), i);
            traverser.traverse(list.getChildListAt(1), allData);
        }
        return 0.0;
    }

}


