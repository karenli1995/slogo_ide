
package command.syntax;

import command.Command;
import controller.ParseTreeChildren;


public class ListEnd extends Command {

    /**
     * 
     */
    private static final long serialVersionUID = -2178229337604706839L;

    public ListEnd () {

    }

    @Override
    public double execute (ParseTreeChildren distance) {
        System.out.println("this happened");
        return 0;
    }

}
