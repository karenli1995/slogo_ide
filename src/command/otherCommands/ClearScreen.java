/**
 *
 */
package command.otherCommands;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;
import command.turtle.turtleCommands.TurtleAbsolutePosition;
import controller.ParseTreeNode;
import javafx.geometry.Point2D;
import model.Data;
import model.Data_Turtle_Interface;
import model.SlogoObjects;
import model.Trail;

/**
 *
 * @author Sally Al
 *
 */
public class ClearScreen extends TurtleAbsolutePosition{

	@Override
	public Data_Turtle_Interface execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {
		List<Double> defaultPosition = new ArrayList<Double>();
		defaultPosition.add(0.0);
		defaultPosition.add(0.0);
		this.setValue(calculateDistanceBetweenTwoPoints(defaultPosition, data));

		SlogoObjects currTurt = data.getTurtle(0);
		
		currTurt.setRotationAngle(0.0);

//		Trail loc = data.getTurtle(0).getTrail();
//		loc.setPoint(new Point2D(0.0, 0.0));
//
//		data.getTurtle(0).setTrail(loc);
//		data.getTurtle(0).getTrail().addCoord(new Point2D(0.0, 0.0));
		
		currTurt.setClearTrail(true);
		data.setTurtle(0, currTurt);

		return data;
	}

}
