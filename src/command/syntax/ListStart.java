package command.syntax;

import command.Command;
import controller.ParseTreeChildren;


public class ListStart extends Command {
    /**
     * 
     */
    private static final long serialVersionUID = -6594570744194002103L;

    public ListStart () {

    }

    @Override
    public double execute (ParseTreeChildren distance) {
        System.out.println("this happened");

        return 0;
    }

}
