/**
 *
 */
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class SetHeading extends TurtleCommands {
    /**
     *
     */
    private static final long serialVersionUID = 6593453308174239806L;
    private DataTurtleInterface turtleData;

    public SetHeading (DataTurtleInterface turtleDate) {
        turtleData = turtleDate;
    }

    @Override
    public double executeCommand (ParseTreeChildren headingAngle) {
        Double turtleCurrentHeading = getTurtle().getRotationAngle();
        Double delta = headingAngle.getCommandValue(0, 0) - turtleCurrentHeading;

        // fix
        getTurtle().setRotationAngle(turtleCurrentHeading + delta);
        setValue(delta);
        turtleData.setTurtle(0, turtleData.getTurtle(0));

        return delta;
    }

}
