package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import model.DataTurtleInterface;
import model.data.Data;


public class CommandFactory {
    private DataTurtleInterface turtleData;
    private Data allData;
    private Map<String, Class<?>> reflectionMap = new HashMap<String, Class<?>>();
    private Map<String, String> reflectionMapString = new HashMap<String, String>();
    private final String CLASS_PROPERTIES = "resources/class";
    private ResourceBundle resource;

    public CommandFactory (Data data) {
        turtleData = data;
        allData = data;

        resource = ResourceBundle.getBundle(CLASS_PROPERTIES);
        Enumeration<String> tempList = resource.getKeys();
        while (tempList.hasMoreElements()) {
            String tempString = tempList.nextElement();
            this.registerCommand(tempString, resource.getString(tempString));
        }
    }

    public void registerCommand (String commandName, Class<?> commandClass) {
        reflectionMap.put(commandName, commandClass);
    }

    public void registerCommand (String commandName, String commandClass) {
        reflectionMapString.put(commandName, commandClass);
    }

    public Command createCommand (String commandName) {
        Class<?> commandClass = null;

        // commandClass = reflectionMap.get(commandName);
        try {

            commandClass = Class.forName(reflectionMapString.get(commandName));
        }
        catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
            else if ((commandClass.getPackage().getName().contains("otherCommands")) || commandClass
                    .getSuperclass().getPackage().getName().contains("otherCommands")) {
                Object[] o = new Object[1];
                o[0] = allData;
                command = (Command) commandConstructor.newInstance(o);
            }
            else {
                command = (Command) commandConstructor.newInstance(new Object[] {});
            }
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            // e.printStackTrace();
            turtleData.setErrorMessage("noArgument");

        }

        return command;
    }
}
