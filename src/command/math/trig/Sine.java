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
public class Sine extends RoundingResults {
	public Sine() {}

	@Override
	public double execute(ParseTreeChildren argument) {
		double sine =Math.sin(Math.toRadians(argument.getCommandValue(0,0)));
		sine = RoundTo2Decimals(sine);
		this.setValue(sine);
		return sine;
	}

}
