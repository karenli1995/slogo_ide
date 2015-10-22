package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.sun.org.apache.xpath.internal.operations.Minus;

import command.CommandFactory;
import command.CommandInterface;
import command.CommandRegister;
import command.booleanOperations.And;
import command.booleanOperations.Equal;
import command.booleanOperations.GreaterThan;
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
import jdk.nashorn.internal.runtime.ParserException;
import model.Data_Turtle_Interface;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private ResourceBundle errorResources;
	private final String INPUT_RESOURCES = "resources/input";
	private final String ERROR_RESOURCES = "resources/error";
	private List<ParseTreeNode<CommandInterface>> nodeList;
	private CommandRegister cr;

	private ResourceBundle resources;
	private Map<String, Integer> commandTimesMap;
	private Map<String, Integer> commandInputMap;

	public Parser(Data_Turtle_Interface allData) {
		errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
		pattern = new Patterner();
		cf = new CommandFactory(allData);
		cr = new CommandRegister(cf);
		this.commandRegistration();
		this.numInputs();
	}

	private void commandRegistration() {
		cr.register();
	}

	public List<ParseTreeNode<CommandInterface>> parse(String input) {
		this.createCommandList(this.removeComments(input));
		nodeList = new ArrayList<ParseTreeNode<CommandInterface>>();
		this.printCommandList();

		if (this.checkInput()) {
			this.createParseTree();
		}
		for (ParseTreeNode<CommandInterface> p : nodeList) {
			this.printTreeInOrder(p);
			System.out.println("");

		}

		return nodeList;
	}

	private int createParseTree() {
		int index = 0;
		commandInputMap = new HashMap<String, Integer>();
		commandTimesMap = new HashMap<String, Integer>();
		while (index < commandList.size()) {
			ParseTreeNode<CommandInterface> newNode = createNewNode(index);
			index = createParseTree(index + 1, newNode);
			nodeList.add(newNode);
		}

		return index;

	}

	private int createParseTree(int index, ParseTreeNode<CommandInterface> head) {

		int numInputs = this.getNumInputs(head);
		// System.out.println(numInputs);

		if (numInputs == 0) {
			return index;
		}
		for (int i = 0; i < numInputs; i++) {
			List<ParseTreeNode<CommandInterface>> tempNodeList = new ArrayList<ParseTreeNode<CommandInterface>>();

			if (commandList.get(index)[1].equals("ListStart")) {
				ParseTreeNode<CommandInterface> listStart = createNewNode(index);
				tempNodeList.add(listStart);
				index++;
				while (true) {
					if (!commandList.get(index)[1].equals("ListEnd")) {
						ParseTreeNode<CommandInterface> newNode = createNewNode(index);
						// System.out.println(commandList.get(index)[1]);
						// System.out.println(index);
						index = createParseTree(index + 1, newNode);
						tempNodeList.add(newNode);
					} else {
						ParseTreeNode<CommandInterface> listEnd = createNewNode(index);
						tempNodeList.add(listEnd);
						index++;

						break;
					}
				}
			} else {
				ParseTreeNode<CommandInterface> newNode = createNewNode(index);
				// System.out.println(commandList.get(index)[1]);
				// System.out.println(index);
				index = createParseTree(index + 1, newNode);
				tempNodeList.add(newNode);
			}

			head.addChild(tempNodeList);
		}

		return index;
	}

	private ParseTreeNode<CommandInterface> createNewNode(int index) {
		ParseTreeNode<CommandInterface> node = new ParseTreeNode<CommandInterface>(
				cf.createCommand(commandList.get(index)[1]));
		if (checkMatch("Constant", node)) {
			this.setNodeValue(index, node);
		} else {
			node.getCommand().setValue(index);
		}
		if (checkMatch("Variable", node) || checkMatch("UserCommand", node)) {
			this.setNodeName(index, node);
		}
		if (checkMatch("UserCommand", node)) {
			for (int i = index; i < commandList.size(); i++) {
				if (commandList.get(i)[1].equals("ListEnd")) {
					int tempInputs = (i - index) - 2;
					commandInputMap.put(commandList.get(index)[0], tempInputs);
					commandTimesMap.put(commandList.get(index)[0], 1);
					break;
				}
			}
		}
		return node;

	}

	private void setNodeValue(int index, ParseTreeNode<CommandInterface> node) {
		node.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
	}

	private void setNodeName(int index, ParseTreeNode<CommandInterface> node) {
		node.getCommand().setName(commandList.get(index)[0]);
	}

	private boolean checkMatch(String s, ParseTreeNode<CommandInterface> node) {
		return node.getCommand().getClass().getSimpleName().equals(s);
	}

	private int getNumInputs(ParseTreeNode<CommandInterface> node) {
		int numInputs = Integer.parseInt(resources.getString(node.getCommand().getClass().getSimpleName()));
		if (checkMatch("UserCommand", node)) {
			if (!commandTimesMap.containsKey(node.getCommand().getName())) {
				numInputs = commandInputMap.get(node.getCommand().getName());
			} else {
				commandTimesMap.remove(node.getCommand().getName());
			}

		}
		return numInputs;
	}
	// private int createParseTree() {
	// int index = 0;
	// commandInputMap = new HashMap<String, Integer>();
	// while (index < commandList.size() - 1) {
	// index = this.createParseTree(index + 1, currentNode);
	// if (index < commandList.size()) {
	//
	// ParseTreeNode<CommandInterface> newNode = new
	// ParseTreeNode<CommandInterface>(
	// cf.createCommand(commandList.get(index)[1]));
	// if (newNode.getCommand().getClass().getSimpleName().equals("Constant")) {
	// newNode.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
	// } else {
	// newNode.getCommand().setValue(index);
	// }
	// if (newNode.getCommand().getClass().getSimpleName().equals("Variable")
	// || newNode.getCommand().getClass().getSimpleName().equals("UserCommand"))
	// {
	// newNode.getCommand().setName(commandList.get(index)[0]);
	// }
	// if (newNode.getCommand().getClass().getSimpleName().equals("UserCommand")
	// && !commandInputMap.containsKey(commandList.get(index)[0])) {
	// for (int i = index; i < commandList.size(); i++) {
	// if (commandList.get(i)[1].equals("ListEnd")) {
	// int tempInputs = (i - index) - 2;
	// commandInputMap.put(commandList.get(index)[0], tempInputs);
	// break;
	// }
	// }
	// }
	// currentNode.addChild(newNode);
	// currentNode = newNode;
	// }
	// }
	// return index;
	// }
	//
	// private int createParseTree(int index, ParseTreeNode<CommandInterface> p)
	// {
	// if (index < commandList.size()) {
	// int numInputs =
	// Integer.parseInt(resources.getString(p.getCommand().getClass().getSimpleName()));
	// if (commandInputMap.containsKey(p.getCommand().getName())
	// &&
	// !p.getParent().getCommand().getClass().getSimpleName().equals("MakeUserInstruction"))
	// {
	// numInputs = commandInputMap.get(p.getCommand().getName());
	// System.out.println(numInputs);
	// }
	// if (p.getCommand().getClass().getSimpleName().equals("DoTimes")) {
	// // System.out.println("turn this to true");
	// doTimesBoolean = true;
	// }
	// if (p.getCommand().getClass().getSimpleName().equals("ListEnd")
	// ||
	// p.getCommand().getClass().getSimpleName().equals("MakeUserInstruction"))
	// {
	// // System.out.println("this happened");
	// doTimesBoolean = false;
	// }
	// if ((doTimesBoolean &&
	// p.getCommand().getClass().getSimpleName().equals("Variable"))
	// || commandList.get(index)[1].equals("ListEnd")) {
	// // System.out.println("this also happened");
	// numInputs = 1;
	// }
	//
	// if (numInputs == 0) {
	// currentNode = p;
	// return index;
	// } else {
	// for (int j = 0; j < numInputs; j++) {
	//
	// ParseTreeNode<CommandInterface> newNode = new
	// ParseTreeNode<CommandInterface>(
	// cf.createCommand(commandList.get(index)[1]));
	// if (newNode.getCommand().getClass().getSimpleName().equals("Constant")) {
	// newNode.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
	// } else {
	// newNode.getCommand().setValue(index);
	// }
	// if (newNode.getCommand().getClass().getSimpleName().equals("Variable")
	// || newNode.getCommand().getClass().getSimpleName().equals("UserCommand"))
	// {
	// newNode.getCommand().setName(commandList.get(index)[0]);
	// }
	// if (newNode.getCommand().getClass().getSimpleName().equals("UserCommand")
	// && !commandInputMap.containsKey(commandList.get(index)[0])) {
	// for (int i = index; i < commandList.size(); i++) {
	// if (commandList.get(i)[1].equals("ListEnd")) {
	// int tempInputs = (i - index) - 2;
	// commandInputMap.put(commandList.get(index)[0], tempInputs);
	// break;
	// }
	// }
	// }
	//
	// p.addChild(newNode);
	// // System.out.println(newNode.getCommand().getClass().getSimpleName());
	// index++;
	// index = createParseTree(index, newNode);
	//
	// }
	// }
	// }
	//
	// return index;
	// }

	public void printCommandList() {
		for (String[] s : commandList) {
			System.out.println(s[0] + ", " + s[1]);
		}
	}

	public void printTreeInOrder(ParseTreeNode<CommandInterface> head) {
		if (head == null)
			return;

		for (List<ParseTreeNode<CommandInterface>> nodeList : head.getChildren()) {
			for (ParseTreeNode<CommandInterface> node : nodeList) {
				printTreeInOrder(node);
			}
		}

		System.out.println(head.getCommand().getClass().getSimpleName() + " " + head.getCommand().getValue() + "->"
				+ head.getParent().getCommand().getClass().getSimpleName() + " "
				+ head.getParent().getCommand().getValue());

	}

	private void numInputs() {
		resources = ResourceBundle.getBundle(INPUT_RESOURCES);
	}

	private void createCommandList(String input) {
		String[] example = this.splitInput(input);
		commandList = pattern.matchSplitCommand(example, pattern.getPatterns());
	}

	private String removeComments(String input) {

		String[] lines = input.split(System.getProperty("line.separator"));
		StringBuilder modifiedString = new StringBuilder();
		for (String s : lines) {
			if (!s.contains("#")) {
				modifiedString.append(s);
				modifiedString.append(System.getProperty("line.separator"));
			}
		}
		return modifiedString.toString();
	}

	public String[] splitInput(String input) {
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}

	public List<String[]> getCommandList() {
		return commandList;
	}

	public Patterner getPattern() {
		return pattern;
	}

	public CommandFactory getCommandFactory() {
		return cf;
	}

	public boolean checkInput() {
		return !commandList.isEmpty();
	}
}
