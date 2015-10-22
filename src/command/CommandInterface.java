package command;

import java.util.List;

import controller.ParseTreeNode;

public interface CommandInterface {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract double execute(List<ParseTreeNode<CommandInterface>> distance);

	public abstract double getValue();

	public void setValue(double d);

}
