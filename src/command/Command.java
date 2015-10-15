package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data;

public abstract class Command {

	protected double value;

	public abstract Data execute(List<ParseTreeNode<Command>> distance, Data data);

	public Command() {
	}

	public double getValue() {
		return value;
	}

	public void setValue(double d) {
		this.value = d;
	}

}
