package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory{
	private Map<String, Class<?>> reflectionMap = new HashMap<String, Class<?>>();

	public CommandFactory(){

	}

	public void registerProduct(String commandName, Class<?> commandClass){
		reflectionMap.put(commandName, commandClass);
	}

	public Command createCommand(String commandName){
		Class<?> commandClass = reflectionMap.get(commandName);
		Constructor<?> commandConstructor = null;
		try {
			commandConstructor = commandClass.getDeclaredConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Command command = null;
		try {
			command = (Command)commandConstructor.newInstance(new Object[] { });
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return command;
	}
}
