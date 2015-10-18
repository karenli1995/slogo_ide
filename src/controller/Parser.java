package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import command.Command;
import command.CommandFactory;
import command.Constant;
import command.DoTimes;
import command.ListEnd;
import command.ListStart;
import command.MakeUserInstruction;
import command.MakeVariable;
import command.Repeat;
import command.UserCommand;
import command.Variable;
import command.math.Quotient;
import command.math.Sine;
import command.math.Sum;
import command.turtleCommands.Backward;
import command.turtleCommands.Forward;
import command.turtleCommands.HideTurtle;
import command.turtleCommands.Home;
import command.turtleCommands.Left;
import command.turtleCommands.PenDown;
import command.turtleCommands.PenUp;
import command.turtleCommands.Right;
import command.turtleCommands.SetHeading;
import command.turtleCommands.SetPosition;
import command.turtleCommands.ShowTurtle;
import command.turtleQueries.Heading;
import command.turtleQueries.IsPenDown;
import command.turtleQueries.XCoordinate;
import command.turtleQueries.YCoordinate;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private ResourceBundle resources;
	private ResourceBundle errorResources;
	private final String INPUT_RESOURCES = "resources/input";
	private final String ERROR_RESOURCES = "resources/error";
	private ParseTreeNode<Command> head;
	private ParseTreeNode<Command> currentNode;
	private List<ParseTreeNode<Command>> nodeList;
	private int bracketCount;
	private boolean doTimesBoolean = false;
	private Map<String, Integer> commandInputMap;

	public Parser() {
		errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
		pattern = new Patterner();
		cf = new CommandFactory();
		this.commandRegistration();
		this.numInputs();
	}

	private void commandRegistration() {
		try {
			cf.registerCommand("Forward", Forward.class);
			cf.registerCommand("Backward", Backward.class);
			cf.registerCommand("Right", Right.class);
			cf.registerCommand("Left", Left.class);
			cf.registerCommand("Home", Home.class);
			cf.registerCommand("SetHeading", SetHeading.class);
			cf.registerCommand("SetPosition", SetPosition.class);
			cf.registerCommand("Heading", Heading.class);
			cf.registerCommand("Constant", Constant.class);
			cf.registerCommand("ListEnd", ListEnd.class);
			cf.registerCommand("ListStart", ListStart.class);
			cf.registerCommand("Repeat", Repeat.class);
			cf.registerCommand("Sum", Sum.class);
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
			// cf.registerCommand("IsShowing", IsShowing.class);
			cf.registerCommand("IsPenDown", IsPenDown.class);

		} catch (Exception e) {
			throw new ParserException(errorResources.getString("commandRegistration"));
		}

	}

	public List<ParseTreeNode<Command>> parse(String input) {
		this.createCommandList(this.removeComments(input));
		nodeList = new ArrayList<ParseTreeNode<Command>>();
		this.printCommandList();

		if (this.checkInput()) {
			this.createHeadNode();
			this.createParseTree();
		}
		this.printTreeInOrder(head);
		nodeList.add(head);
		return nodeList;
	}

	private int createParseTree() {
		int index = 0;
		commandInputMap = new HashMap<String, Integer>();
		while (index < commandList.size() - 1) {
			index = this.createParseTree(index + 1, currentNode);
			if (index < commandList.size()) {

				ParseTreeNode<Command> newNode = new ParseTreeNode<Command>(
						cf.createCommand(commandList.get(index)[1]));
				if (newNode.getCommand().getClass().getSimpleName().equals("Constant")) {
					newNode.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
				} else {
					newNode.getCommand().setValue(index);
				}
				if (newNode.getCommand().getClass().getSimpleName().equals("Variable")
						|| newNode.getCommand().getClass().getSimpleName().equals("UserCommand")) {
					newNode.getCommand().setName(commandList.get(index)[0]);
				}
				if (newNode.getCommand().getClass().getSimpleName().equals("UserCommand")
						&& !commandInputMap.containsKey(commandList.get(index)[0])) {
					for (int i = index; i < commandList.size(); i++) {
						if (commandList.get(i)[1].equals("ListEnd")) {
							int tempInputs = (i - index) - 2;
							commandInputMap.put(commandList.get(index)[0], tempInputs);
							break;
						}
					}
				}
				currentNode.addChild(newNode);
				currentNode = newNode;
			}
		}
		return index;
	}

	private int createParseTree(int index, ParseTreeNode<Command> p) {
		if (index < commandList.size()) {
			int numInputs = Integer.parseInt(resources.getString(p.getCommand().getClass().getSimpleName()));
			if (commandInputMap.containsKey(p.getCommand().getName())
					&& !p.getParent().getCommand().getClass().getSimpleName().equals("MakeUserInstruction")) {
				numInputs = commandInputMap.get(p.getCommand().getName());
				System.out.println(numInputs);
			}
			if (p.getCommand().getClass().getSimpleName().equals("DoTimes")) {
				// System.out.println("turn this to true");
				doTimesBoolean = true;
			}
			if (p.getCommand().getClass().getSimpleName().equals("ListEnd")
					|| p.getCommand().getClass().getSimpleName().equals("MakeUserInstruction")) {
				// System.out.println("this happened");
				doTimesBoolean = false;
			}
			if ((doTimesBoolean && p.getCommand().getClass().getSimpleName().equals("Variable"))
					|| commandList.get(index)[1].equals("ListEnd")) {
				// System.out.println("this also happened");
				numInputs = 1;
			}

			if (numInputs == 0) {
				currentNode = p;
				return index;
			} else {
				for (int j = 0; j < numInputs; j++) {

					ParseTreeNode<Command> newNode = new ParseTreeNode<Command>(
							cf.createCommand(commandList.get(index)[1]));
					if (newNode.getCommand().getClass().getSimpleName().equals("Constant")) {
						newNode.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
					} else {
						newNode.getCommand().setValue(index);
					}
					if (newNode.getCommand().getClass().getSimpleName().equals("Variable")
							|| newNode.getCommand().getClass().getSimpleName().equals("UserCommand")) {
						newNode.getCommand().setName(commandList.get(index)[0]);
					}
					if (newNode.getCommand().getClass().getSimpleName().equals("UserCommand")
							&& !commandInputMap.containsKey(commandList.get(index)[0])) {
						for (int i = index; i < commandList.size(); i++) {
							if (commandList.get(i)[1].equals("ListEnd")) {
								int tempInputs = (i - index) - 2;
								commandInputMap.put(commandList.get(index)[0], tempInputs);
								break;
							}
						}
					}

					p.addChild(newNode);
					System.out.println(newNode.getCommand().getClass().getSimpleName());
					index++;
					index = createParseTree(index, newNode);

				}
			}
		}

		return index;
	}

	public void printCommandList() {
		for (String[] s : commandList) {
			System.out.println(s[0] + ", " + s[1]);
		}
	}

	public void printTreeInOrder(ParseTreeNode<Command> head) {
		if (head == null)
			return;

		for (ParseTreeNode<Command> node : head.getChildren()) {
			printTreeInOrder(node);
		}

		System.out.println(head.getCommand().getClass().getSimpleName() + " " + head.getCommand().getValue() + "->"
				+ head.getParent().getCommand().getClass().getSimpleName() + " "
				+ head.getParent().getCommand().getValue());
	}

	private void numInputs() {
		resources = ResourceBundle.getBundle(INPUT_RESOURCES);
	}

	private void createHeadNode() {
		head = new ParseTreeNode<Command>(cf.createCommand(commandList.get(0)[1]));
		currentNode = head;
	}

	private void createCommandList(String[] input) {
		commandList = pattern.matchSplitCommand(input, pattern.getPatterns());
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
