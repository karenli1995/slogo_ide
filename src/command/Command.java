package command;

import java.util.List;

import model.Data;

public abstract class Command{

	protected int value;
	protected List<Command> children;

	public abstract void returnValue();

	//public abstract void execute();

	public Command(){
	}
	
	public int getValue() {

		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Command> getChildren() {
		return children;
	}

	public void setChildren(List<Command> children) {
		this.children = children;
	}
}
