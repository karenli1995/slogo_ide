/**
 *
 */
package command.math.trig;

import command.RoundingResults;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Cos extends RoundingResults {
	public Cos(){
		super();
	}
	@Override
	public double execute(ParseTreeChildren argument) {
		double cosangle=Math.cos(Math.toRadians(argument.getCommandValue(0,0)));
		cosangle=RoundTo2Decimals(cosangle);
		this.setValue(cosangle);
		return cosangle;
	}

}
