package command.otherCommands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.Data;


public class UserCommand extends Command {
    private Data allData;
    Traverser traverser = new Traverser();
    Map<String, Double> localMap;
    Map<String, Double> tempMap;

    public UserCommand (Data allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren distance) {
        double ans = 0;
        if (allData.getUserCommandMap().containsKey(getName()) && !distance.getParent().getParent()
                .getCommand().getClass().getSimpleName().equals("MakeUserInstruction")) {
            List<ParseTreeNode<CommandInterface>> temp =
                    allData.getUserCommandMap().get(getName());
            List<String> tempString = allData.getMyCommandVariableMap().get(getName());
            localMap = new HashMap<String, Double>(allData.getVariableMap());
            tempMap = allData.getVariableMap();
            for (int i = 0; i < distance.getNodeList().size(); i++) {

                localMap.put(tempString.get(i), distance.getCommandValue(i, 0));
            }
            allData.setVariableMap(localMap);
            ans = traverser.traverse(temp, allData);
            allData.setVariableMap(tempMap);
        }

        return ans;
    }

}
