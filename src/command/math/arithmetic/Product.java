
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputCommand;
import controller.ParseTreeChildren;
import model.data.Data;

/**
 *
 * @author Sally Al
 *
 */
public class Product extends UnlimitedInputCommand {
	public Product(Data allData) {
		super(allData);
	}

	private static final long serialVersionUID = -3795052450458213450L;

	@Override
	public double execute(ParseTreeChildren arguments) {
		double ans = parameterLoop((list) -> list.stream().reduce((x, y) -> x * y).get(), arguments);
		this.setValue(ans);
		return ans;
	}

}
