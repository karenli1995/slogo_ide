/**
 *
 */
package command.turtle.turtleQueries;

import command.Command;
import controller.ParseTreeChildren;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public class XCoordinate extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7399635693097670130L;
	private Data_Turtle_Interface turtleData;

	public XCoordinate(Data_Turtle_Interface data) {
		super(data);
		turtleData = data;
	}

	@Override
	public double execute(ParseTreeChildren distance) {
		double x = turtleData.getTurtle(0).getTrail().getX();
		// turtleScene.getCentrex();
		this.setValue(x);
		return x;
	}

}
