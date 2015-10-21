package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data;

public interface CommandInterface {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract Data execute(List<ParseTreeNode<CommandInterface>> distance, Data data);

	public abstract double getValue();

	public void setValue(double d);

}
