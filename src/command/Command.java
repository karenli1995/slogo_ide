package command;

import java.util.List;

import model.Data;

public abstract class Command{

	protected int value;

	public abstract double execute(List<Double> distance, Data data);

	public Command(){
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
