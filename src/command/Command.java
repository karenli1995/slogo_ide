/**
 *
 */
package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data;

/**
 *
 * @author Sally Al
 *
 */
public abstract class Command implements CommandInterface {
	private String name;

	private double value;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data) {

		return null;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double d) {
		this.value = d;
	}

}
