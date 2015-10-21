package command;

import java.util.List;
import java.util.Observable;

import controller.ParseTreeNode;
import model.Data;
import model.MathCommand;

public abstract class Command{
	protected String name;
	protected double value;
//	protected MathCommand myMathCommand;
	
	public Command() {
//		myMathCommand = new MathCommand();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public abstract Data execute(List<ParseTreeNode<Command>> distance, Data data, MathCommand mathcommand);



	public double getValue() {
		return value;
	}

	public void setValue(double d) {
		this.value = d;
//		double prevValue = myMathCommand.getMathValue();
//		myMathCommand.setMathValue(this.value);
	}

}
