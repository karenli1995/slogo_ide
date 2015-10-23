/**
 *
 */
package model;

import java.util.List;

/**
 *
 * @author Sally Al
 *
 */
public interface Data_Turtle_Interface {

	public SlogoObjects getTurtle(int turtleId);
	public void  setTurtle(int turtleId, SlogoObjects turtle);
	public void updateVaraibleMap(String varName, Double value);
	public List<SlogoObjects> getAllTurtles();

}