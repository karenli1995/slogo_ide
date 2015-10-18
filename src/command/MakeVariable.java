package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.ParseTreeNode;
import model.Data;

public class MakeVariable extends Command {
	private static Map<String, Double> varaibleMap = new HashMap<String, Double>();

	@Override
	public Data execute(List<ParseTreeNode<Command>> argument, Data data) {
		//varaibleMap = data.getVariableMap();
		String varName = argument.get(0).getCommand().getClass().getSimpleName().toString();
		Double value = argument.get(1).getCommand().getValue();
		if (varaibleMap.containsKey(varName)) {
			varaibleMap.put(varName, value);
		} else {
			varaibleMap.put(varName, value);
		}
		data.setVariableMap(varaibleMap);
		return data;
	}

}
