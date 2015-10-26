
package command.commandsObservers;

import java.util.Observable;
import java.util.Observer;

import command.turtle.turtleCommands.TurtleCommands;
import javafx.geometry.Point2D;
import model.data.Data;
import model.turtleinfo.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public class TurtleCommandsObserver implements Observer {
	private Data data;

	public TurtleCommandsObserver(Data data) {
		this.data = data;
	}

	@Override
	public void update(Observable o, Object arg) {
		TurtleCommands observedClass = (TurtleCommands) o;

		Point2D NewCoordinate = new Point2D(observedClass.getCoordinates().get("XCor"),
				observedClass.getCoordinates().get("YCor"));
		int index = observedClass.getCoordinates().get("id").intValue();
		SlogoObjects turtle = data.getTurtle(index);

		turtle.getTrail().addCoord(NewCoordinate, turtle.getPen().isDown(), turtle.getPen().getColor().toString(),
				turtle.getPen().getThickness(), turtle.getPen().getDashes());
		turtle.setTrail(turtle.getTrail());
		turtle.getTrail().setPoint(NewCoordinate);
		turtle.setRotationAngle(observedClass.getCoordinates().get("Angle"));
		data.setTurtle(index, turtle);

	}

}
