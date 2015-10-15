package controller;

import java.util.List;
import java.util.ResourceBundle;

import command.Command;
import command.CommandFactory;
import command.Constant;
import command.ListEnd;
import command.ListStart;
import command.Repeat;
import command.math.Sum;
import command.turtleCommands.Forward;
import command.turtleCommands.Right;
import command.CommandFactory;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private ResourceBundle resources;
	private final String INPUT_RESOURCES = "resources/input";
	private ParseTreeNode<Command> head;
	private ParseTreeNode<Command> currentNode;

	public Parser() {
		pattern = new Patterner();
		cf = new CommandFactory();
		this.commandRegistration();
		this.numInputs();
	}

	private void commandRegistration() {
		cf.registerCommand("Forward", Forward.class);
		cf.registerCommand("Constant", Constant.class);
		cf.registerCommand("ListEnd", ListEnd.class);
		cf.registerCommand("ListStart", ListStart.class);
		cf.registerCommand("Repeat", Repeat.class);
		cf.registerCommand("Right", Right.class);
		cf.registerCommand("Sum", Sum.class);
	}

	public ParseTreeNode<Command> parse(String input) {
		this.createCommandList(this.removeComments(input));

		this.createHeadNode();
		this.createParseTree();
		this.printTreeInOrder(head);
		return head;
	}

	private int createParseTree() {
		int index = 0;
		while (index < commandList.size()) {
			index = this.createParseTree(index + 1, currentNode);
			if (index < commandList.size()) {
				ParseTreeNode<Command> newNode = new ParseTreeNode<Command>(
						cf.createCommand(commandList.get(index)[1]));
				currentNode.addChild(newNode);
				currentNode = newNode;
			}
		}
		return index;
	}

	private int createParseTree(int index, ParseTreeNode<Command> p) {
		int numInputs = Integer.parseInt(resources.getString(p.getCommand().getClass().getSimpleName()));
		if (numInputs == 0) {
			numInputs++;
		}
		// System.out.println(numInputs);

		if (p.getCommand().getClass().getSimpleName().equals("Constant")
				|| p.getCommand().getClass().getSimpleName().equals("ListEnd")) {
			currentNode = p;
			return index;
		} else {
			for (int j = 0; j < numInputs; j++) {
				ParseTreeNode<Command> newNode = new ParseTreeNode<Command>(
						cf.createCommand(commandList.get(index)[1]));
				if (newNode.getCommand().getClass().getSimpleName().equals("Constant")) {
					((Command) newNode.getCommand()).setValue(Integer.parseInt(commandList.get(index)[0]));
				} else {
					((Command) newNode.getCommand()).setValue(index);
				}
				p.addChild(newNode);
				index++;
				index = createParseTree(index, newNode);
			}
		}
		return index;
	}

	public void printTreeInOrder(ParseTreeNode<Command> head) {
		if (head == null)
			return;

		for (ParseTreeNode<Command> node : head.getChildren()) {
			printTreeInOrder(node);
		}

		System.out.println(head.getCommand().getClass().getSimpleName() + " " + ((Command) head.getCommand()).getValue()
				+ "->" + head.getParent().getCommand().getClass().getSimpleName() + " "
				+ ((Command) head.getParent().getCommand()).getValue());
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
}
