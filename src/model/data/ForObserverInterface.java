/**
 *
 */
package model.data;

import java.util.List;
import java.util.Map;

import command.CommandInterface;
import controller.ParseTreeNode;


/**
 *
 * @author Sally Al
 *
 */
public interface ForObserverInterface {

    public double getCommandValue ();

    public void setCommandValue (double commandValue);

    public String getErrorMessage ();

    public void setErrorMessage (String errorMessage);

    public Map<String, Double> getVariableMap ();

    public Map<String, List<ParseTreeNode<CommandInterface>>> getUserCommandMap ();
}
