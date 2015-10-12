package command;

import java.util.List;

public abstract class Command{

	protected int value;
	protected List<Command> children;

	public abstract int execute(List<Integer> distance);

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
