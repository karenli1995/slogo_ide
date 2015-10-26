/**
 *
 */
package command.turtle.turtleCommands;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import command.Command;
import controller.ParseTreeChildren;
import model.DataTurtleInterface;
import model.turtleinfo.SlogoObjects;

/***
 * @author Sally Al
 ***/
public abstract class TurtleCommands extends Command {

	private static final long serialVersionUID = 3800846758549642667L;

	private Map<String, Double> coordinates = new HashMap<String, Double>();

	private static final String XCOR = "XCor";
	private static final String YCOR = "YCor";
	private static final String ANGLE = "Angle";
	private static final String ID = "id";

	public TurtleCommands() {
		// for sine and cosine

	}

	private DataTurtleInterface turtleData;

	public TurtleCommands(DataTurtleInterface turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	protected double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	protected void updateLocation(Double x, Double y, double angle) {

		coordinates.put(XCOR, x);
		coordinates.put(YCOR, y);
		coordinates.put(ANGLE, angle);
		coordinates.put(ID, (double) id);
		setChanged();
		notifyObservers();
	}

	public Map<String, Double> getCoordinates() {
		return coordinates;
	}

	int id = 0;

	@Override
	public double execute(ParseTreeChildren distance) {
		int range = turtleData.activeTurtleListSize();
		double value = 0;

		for (int i = 0; i < range; i++) {
			id = turtleData.activeTurtleListValue(i);
			value = executeCommand(distance);
			this.setValue(value);
		}
		return value;

	}

	public abstract double executeCommand(ParseTreeChildren distance);


	protected SlogoObjects getTurtle(){
		return turtleData.getTurtle(id);
	}

	protected double getCurrX(){
		return getTurtle().getTrail().getX();
	}

	protected double getCurrY(){
		return getTurtle().getTrail().getY();
	}

}