package command;

import java.util.List;
import java.util.Observable;

import controller.ParseTreeNode;
import model.Data;

public abstract class Command extends Observable{
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
