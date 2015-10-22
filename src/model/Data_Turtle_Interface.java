/**
 *
 */
package model;

/**
 *
 * @author Sally Al
 *
 */
public interface Data_Turtle_Interface {

	SlogoObjects getTurtle(int turtleId);
	void  setTurtle(int turtleId, SlogoObjects turtle);
	public void updateVaraibleMap(String varName, Double value);

}