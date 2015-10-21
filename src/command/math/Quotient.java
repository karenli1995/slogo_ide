/**
 *
 */
package command.math;

import java.util.List;

import command.CommandInterface;
import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Quotient extends CommandInterface {

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> argument, Data data) {

		double quotient = 0;

		try {
			quotient = argument.get(0).getCommand().getValue() / argument.get(1).getCommand().getValue();

		} catch (ArithmeticException e) {
			// TODO: BOOLEAN IN DATA AND MESSAGE AND PROPERTIES
			System.out.println("Division by zero is not allowed.");
		}

		this.setValue(quotient);
		return data;
	}

}
