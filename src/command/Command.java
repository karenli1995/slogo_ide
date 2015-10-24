/**
 *
 */
package src.command;

import java.io.Serializable;
import java.util.Observable;

import command.CommandInterface;
import controller.ParseTreeChildren;
import model.Data;
import model.Data_Turtle_Interface;

/**
 *
 * @author Sally Al
 *
 */
public abstract class Command extends Observable implements CommandInterface, Serializable {


	private static final long serialVersionUID = -8555344826572870264L;

public Command(){}
public Command(Data_Turtle_Interface allData){}
public Command(Data allData){}

	private String name;

	private double value;

	@Override
	public String getName() {
		return name;

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public abstract double execute(ParseTreeChildren distance);

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double d) {
		this.value = d;
	}


}
