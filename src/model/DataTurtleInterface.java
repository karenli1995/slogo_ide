/**
 *
 */
package model;

import java.util.List;

import model.turtleinfo.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public interface DataTurtleInterface {

	public SlogoObjects getTurtle(int turtleId);
	public void  setTurtle(int turtleId, SlogoObjects turtle);
	public void updateVaraibleMap(String varName, Double value);
	public List<SlogoObjects> getAllTurtles();
	void setErrorMessage(String errorMessage);
	public int activeTurtleListSize();
	public int turtleListSize();
	int activeTurtleListValue(int index);
	public void createTurtle();
	public void addToActiveList(int value);
	int getActiveTurtleID();

}