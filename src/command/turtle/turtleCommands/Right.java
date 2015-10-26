/**
 *
 */
package command.turtle.turtleCommands;

import model.DataTurtleInterface;


/**
 *
 * @author Sally Al
 *
 */
public class Right extends TurtleDirection {

    /**
     * 
     */
    private static final long serialVersionUID = -5679997306598924872L;

    public Right (DataTurtleInterface turtleData) {
        super(turtleData);
    }

    @Override
    protected int sign () {
        return 1;
    }

}
