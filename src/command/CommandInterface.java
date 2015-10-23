package command;

import java.io.Serializable;
import java.util.List;

import controller.ParseTreeNode;

public interface CommandInterface extends Serializable {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract double execute(List<List<ParseTreeNode<CommandInterface>>> distance);

	public abstract double getValue();

	public void setValue(double d);

}
