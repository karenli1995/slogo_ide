
package command.commandsObservers;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import command.turtle.turtleCommands.TurtleCommands;
import javafx.geometry.Point2D;
import model.data.Data;
import model.turtleinfo.SlogoObjects;


/**
 *
 * @author Sally Al
 *
 */
public class TurtleCommandsObserver implements Observer, Serializable {

  private static final long serialVersionUID = 8077018140841818623L;
  private Data data;
  private ResourceBundle errorResources;
  private final String ERROR_RESOURCES = "resources/error";

  public TurtleCommandsObserver(Data data) {
    this.data = data;
    errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
  }

  @Override
  public void update(Observable o, Object arg) {
    TurtleCommands observedClass = (TurtleCommands) o;
    double ycor = observedClass.getCoordinates().get("YCor");
    if (ycor == -1000000.0) {
      data.setErrorMessage(errorResources.getString("noArgument"));

    } else {
      Point2D NewCoordinate = new Point2D(observedClass.getCoordinates().get("XCor"), ycor);
      int index = observedClass.getCoordinates().get("id").intValue();
      SlogoObjects turtle = data.getTurtle(index);

      turtle.getTrail().addCoord(NewCoordinate, turtle.getPen().isDown(),
                                 turtle.getPen().getColor().toString(),
                                 turtle.getPen().getThickness(), turtle.getPen().getDashes());
      turtle.setTrail(turtle.getTrail());
      turtle.getTrail().setPoint(NewCoordinate);
      turtle.setRotationAngle(observedClass.getCoordinates().get("Angle"));
      data.setTurtle(index, turtle);
    }

  }

}
