package command;

import java.util.List;

import controller.ParseTreeNode;
import model.Data;

public abstract class Command {
	protected String name;
	protected double value;
	public Command() {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public abstract Data execute(List<ParseTreeNode<Command>> distance, Data data);



	public double getValue() {
		return value;
	}

	public void setValue(double d) {
		this.value = d;
	}

}
