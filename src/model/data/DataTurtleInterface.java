
package model.data;

import java.util.List;

import command.commandsObservers.TurtleCommandsObserver;
import model.turtleinfo.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public interface DataTurtleInterface {

	public SlogoObjects getTurtle(int turtleId);

	public void setTurtle(int turtleId, SlogoObjects turtle);

	public void updateVariableMap(String varName, Double value);

	public List<SlogoObjects> getAllTurtles();

	void setErrorMessage(String errorMessage);

	public int activeTurtleListSize();

	public int turtleListSize();

	int activeTurtleListValue(int index);

	public void createTurtle();

	public void addToActiveList(int value);

	int getActiveTurtleID();

	public TurtleCommandsObserver getTurtleCommandsObserver();

	void setActiveTurtle(int value);
	void removeElementActiveList(int index);

}