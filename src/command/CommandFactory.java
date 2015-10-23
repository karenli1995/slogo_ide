package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import model.Data_Turtle_Interface;


public class CommandFactory {
    private Data_Turtle_Interface turtleData;
    private Map<String, Class<?>> reflectionMap = new HashMap<String, Class<?>>();
    private Map<String, String> reflectionMapString = new HashMap<String, String>();

    public CommandFactory (Data_Turtle_Interface data) {
        turtleData = data;
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
//        try {
//            commandClass = Class.forName(reflectionMapString.get(commandName));
//        }
//        catch (ClassNotFoundException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
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
            else {
                command = (Command) commandConstructor.newInstance(new Object[] {});
            }
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }
}
