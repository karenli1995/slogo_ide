package command.otherCommands;

import java.util.HashMap;
import java.util.Map;

public class Variable  {

	private static Map<String, Double> varaibleMap = new HashMap<String, Double>();


	public Boolean containsKey(String varName){
		return varaibleMap.containsKey(varName);
	}
	public void put(String varName, Double value){
		varaibleMap.put(varName, value);
	}
	public Map<String, Double> getMap(){
		return varaibleMap;
	}


}
