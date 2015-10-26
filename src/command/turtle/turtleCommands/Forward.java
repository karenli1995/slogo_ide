package command.turtle.turtleCommands;

import model.DataTurtleInterface;


public class Forward extends TurtleMovement {

    /**
     *
     */
    private static final long serialVersionUID = 5686629616609060685L;

    public Forward (DataTurtleInterface data) {
        super(data);
    }

    @Override
    protected int getSign () {
        return 1;
    }

}
