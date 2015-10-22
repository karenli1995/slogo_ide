/**
 *
 */
package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class Command implements CommandInterface {

public Command(){}
public Command(Data_Turtle_Interface allData){}

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
	public abstract double execute(List<List<ParseTreeNode<CommandInterface>>> distance);

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double d) {
		this.value = d;
	}
	public void test(){}

}
