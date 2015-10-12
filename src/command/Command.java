package command;

import java.util.List;

public abstract class Command{

	protected int value;

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

}
