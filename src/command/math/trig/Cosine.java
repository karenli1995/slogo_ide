/**
 *
 */
package command.math.trig;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Cosine extends TurtleCommands {
	/**
	 *
	 */
	private static final long serialVersionUID = -8210600920444364245L;
	public Cosine(){
		super();
	}
	@Override
	public double executeCommand(ParseTreeChildren argument) {
		double cosangle=Math.cos(Math.toRadians(argument.getCommandValue(0,0)));
		cosangle=RoundTo2Decimals(cosangle);
		this.setValue(cosangle);
		return cosangle;
	}

}
