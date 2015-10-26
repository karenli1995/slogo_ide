package command.otherCommands;

import java.util.List;
import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.Data;


public class UserCommand extends Command {
    private Data allData;
    Traverser traverser = new Traverser();

    public UserCommand (Data allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren distance) {
        double ans = 0;
        if (allData.getUserCommandMap().containsKey(getName())) {
            List<ParseTreeNode<CommandInterface>> temp =
                    allData.getUserCommandMap().get(getName());
            List<String> tempString = allData.getMyCommandVariableMap().get(getName());
            for (int i = 0; i < distance.getNodeList().size(); i++) {

                allData.getVariableMap().put(tempString.get(i), distance.getCommandValue(i, 0));
            }
            ans = traverser.traverse(temp, allData);
        }

        return ans;
    }

}
