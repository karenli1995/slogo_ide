/**
 *
 */
package command;

import java.text.DecimalFormat;

import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class RoundingResults extends Command {

	public RoundingResults() {}
	public RoundingResults(Data_Turtle_Interface allData) {}


	protected double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}
}