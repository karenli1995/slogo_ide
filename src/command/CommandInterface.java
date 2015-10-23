package command;

import controller.ParseTreeChildren;
import java.io.Serializable;
import java.util.List;

import controller.ParseTreeNode;

public interface CommandInterface extends Serializable {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract double getValue();

	public void setValue(double d);

	public abstract double execute(ParseTreeChildren distance);

}
