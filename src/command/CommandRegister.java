package command;

import com.sun.org.apache.xpath.internal.operations.Minus;

import command.booleanOperations.And;
import command.booleanOperations.Equal;
import command.booleanOperations.Greater;
import command.booleanOperations.LessThan;
import command.booleanOperations.Not;
import command.booleanOperations.NotEqual;
import command.booleanOperations.Or;
import command.math.Atan;
import command.math.Cos;
import command.math.Difference;
import command.math.Log;
import command.math.Pi;
import command.math.Power;
import command.math.Product;
import command.math.Quotient;
import command.math.RandomNumber;
import command.math.Remainder;
import command.math.Sine;
import command.math.Sum;
import command.math.Tan;
import command.otherCommands.DoTimes;
import command.otherCommands.MakeUserInstruction;
import command.otherCommands.Repeat;
import command.otherCommands.UserCommand;
import command.otherCommands.Variable;
import command.syntax.Constant;
import command.syntax.ListEnd;
import command.syntax.ListStart;
import command.turtle.turtleCommands.Backward;
import command.turtle.turtleCommands.ClearScreen;
import command.turtle.turtleCommands.Forward;
import command.turtle.turtleCommands.HideTurtle;
import command.turtle.turtleCommands.Home;
import command.turtle.turtleCommands.Left;
import command.turtle.turtleCommands.MakeVariable;
import command.turtle.turtleCommands.PenDown;
import command.turtle.turtleCommands.PenUp;
import command.turtle.turtleCommands.Right;
import command.turtle.turtleCommands.SetHeading;
import command.turtle.turtleCommands.SetPosition;
import command.turtle.turtleCommands.ShowTurtle;
import command.turtle.turtleQueries.Heading;
import command.turtle.turtleQueries.IsPenDown;
import command.turtle.turtleQueries.XCoordinate;
import command.turtle.turtleQueries.YCoordinate;

public class CommandRegister {
	private CommandFactory cf;
	public CommandRegister(CommandFactory commandfac){
		cf = commandfac;
	}

	public void register(){
		cf.registerCommand("Forward", Forward.class);
		cf.registerCommand("Backward", Backward.class);
		cf.registerCommand("Right", Right.class);
		cf.registerCommand("Left", Left.class);
		cf.registerCommand("Home", Home.class);
		cf.registerCommand("SetHeading", SetHeading.class);
		cf.registerCommand("SetPosition", SetPosition.class);
		cf.registerCommand("ClearScreen", ClearScreen.class);
		cf.registerCommand("Heading", Heading.class);
		cf.registerCommand("Constant", Constant.class);
		cf.registerCommand("ListEnd", ListEnd.class);
		cf.registerCommand("ListStart", ListStart.class);
		cf.registerCommand("Repeat", Repeat.class);
		cf.registerCommand("Sum", Sum.class);
		cf.registerCommand("Product", Product.class);
		cf.registerCommand("ArcTangent", Atan.class);
		cf.registerCommand("Cosine", Cos.class);
		cf.registerCommand("Difference", Difference.class);
		cf.registerCommand("Log", Log.class);
		cf.registerCommand("Minus", Minus.class);
		cf.registerCommand("Pi", Pi.class);
		cf.registerCommand("Power", Power.class);
		cf.registerCommand("Quotient", Quotient.class);
		cf.registerCommand("Random", RandomNumber.class);
		cf.registerCommand("Remainder", Remainder.class);
		cf.registerCommand("Sine", Sine.class);
		cf.registerCommand("Tangent", Tan.class);
		cf.registerCommand("IsPenDown", IsPenDown.class);
		cf.registerCommand("DoTimes", DoTimes.class);
		cf.registerCommand("Quotient", Quotient.class);
		cf.registerCommand("Sine", Sine.class);
		cf.registerCommand("MakeUserInstruction", MakeUserInstruction.class);
		cf.registerCommand("PenUp", PenUp.class);
		cf.registerCommand("PenDown", PenDown.class);
		cf.registerCommand("MakeVariable", MakeVariable.class);
		cf.registerCommand("Variable", Variable.class);
		cf.registerCommand("UserCommand", UserCommand.class);
		cf.registerCommand("HideTurtle", HideTurtle.class);
		cf.registerCommand("ShowTurtle", ShowTurtle.class);
		cf.registerCommand("PenDown", PenDown.class);
		cf.registerCommand("PenUp", PenUp.class);
		cf.registerCommand("PenUp", PenUp.class);
		cf.registerCommand("XCoordinate", XCoordinate.class);
		cf.registerCommand("YCoordinate", YCoordinate.class);
		cf.registerCommand("IsPenDown", IsPenDown.class);
		cf.registerCommand("And", And.class);
		cf.registerCommand("Or", Or.class);
		cf.registerCommand("Greater",Greater.class);
		cf.registerCommand("Equal", Equal.class);
		cf.registerCommand("NotEqual", NotEqual.class);
		cf.registerCommand("LessThan", LessThan.class);
		cf.registerCommand("Not", Not.class);

	}
}
