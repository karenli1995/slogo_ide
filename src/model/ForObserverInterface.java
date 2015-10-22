/**
 *
 */
package model;

import java.util.Map;

import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public interface ForObserverInterface {

	double getCommandValue();

	void setCommandValue(double commandValue);

	String getErrorMessage();

	void setErrorMessage(String errorMessage);

	public Map<String, Double> getVariableMap();

	public Map<String, ParseTreeNode<CommandInterface>> getUserCommandMap();
}
