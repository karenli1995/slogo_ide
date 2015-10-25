/**
 *
 */
package command;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import model.DataTurtleInterface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleCommands extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3800846758549642667L;

	private Map<String, Double> coordinates = new HashMap<String, Double>();

	private static final String XCOR = "XCor";
	private static final String YCOR = "YCor";
	private static final String ANGLE = "Angle";

	public TurtleCommands() {
	}

	public TurtleCommands(DataTurtleInterface allData) {
	}

	protected double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	protected void updateLocation(Double x, Double y, double angle) {

		coordinates.put(XCOR, x);
		coordinates.put(YCOR, y);
		coordinates.put(ANGLE, angle);
		setChanged();
		notifyObservers();
	}

	public double getXCor() {
		return coordinates.get(XCOR);
	}

	public double getYCor() {
		return coordinates.get(YCOR);
	}

	public double getAngle() {
		return coordinates.get(ANGLE);
	}

	public Map<String, Double> getCoordinates() {
		return coordinates;
	}
}