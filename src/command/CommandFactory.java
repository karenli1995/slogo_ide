package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import model.Data;
import model.Data_Turtle_Interface;
import model.ForObserverInterface;


public class CommandFactory {
    private Data_Turtle_Interface turtleData;
    private ForObserverInterface errorData;
    private Map<String, Class<?>> reflectionMap = new HashMap<String, Class<?>>();
    private Map<String, String> reflectionMapString = new HashMap<String, String>();

    public CommandFactory (Data data) {
        turtleData = data;
        errorData=data;
    }

    public void registerCommand (String commandName, Class<?> commandClass) {
        reflectionMap.put(commandName, commandClass);
    }

    public void registerCommand (String commandName, String commandClass) {
        reflectionMapString.put(commandName, commandClass);
    }

    public Command createCommand (String commandName) {
        Class<?> commandClass = null;

        commandClass = reflectionMap.get(commandName);

        Constructor<?> commandConstructor = null;
        try {// based on name grab constractor

            commandConstructor = commandClass.getDeclaredConstructors()[0];

        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        Command command = null;
        try {// creating the instance

            if (commandClass.getPackage().getName().contains("turtle")) {
                Object[] o = new Object[1];
                o[0] = turtleData;
                command = (Command) commandConstructor.newInstance(o);
            }
            else if((commandClass.getPackage().getName().contains("otherCommands"))){
            	Object[] o = new Object[2];
                o[0] = turtleData;
                o[1]=errorData;
                command = (Command) commandConstructor.newInstance(o);
            }
            else {
                command = (Command) commandConstructor.newInstance(new Object[] {});
            }
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
        	//e.printStackTrace();
        	turtleData.setErrorMessage("noArgument");



        }

        return command;
    }
}
