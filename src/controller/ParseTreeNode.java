package controller;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;

public class ParseTreeNode<Command> {



	private Command command;

	private List<List<ParseTreeNode<Command>>> children;
	private ParseTreeNode<Command> parent = this;

	public ParseTreeNode() {
		super();
		children = new ArrayList<List<ParseTreeNode<Command>>>();
	}

	public ParseTreeNode(Command command) {
		this();
		setCommand(command);

	}

	public List<List<ParseTreeNode<Command>>> getChildren() {
		return this.children;
	}

	public int getNumberOfChildren() {
		return getChildren().size();
	}

	public boolean hasChildren() {
		return (getNumberOfChildren() > 0);
	}

	public void setChildren(List<List<ParseTreeNode<Command>>> children) {
		this.children = children;
	}

	public void addChild(List<ParseTreeNode<Command>> child) {
		children.add(child);
		for (ParseTreeNode<Command> p : child) {
			p.setParent(this);
		}
	}

	public void addChildAt(int index, List<ParseTreeNode<Command>> child) throws IndexOutOfBoundsException {
		children.add(index, child);
	}

	public void removeChildren() {
		this.children = new ArrayList<List<ParseTreeNode<Command>>>();
	}

	public void removeChildListAt(int index) throws IndexOutOfBoundsException {
		children.remove(index);
	}

	public List<ParseTreeNode<Command>> getChildListAt(int index) throws IndexOutOfBoundsException {
		return children.get(index);
	}

	public Command getCommand() {

		return this.command;
	}

	public void setCommand(Command command) {
		this.command = command;

	}

	public void setParent(ParseTreeNode<Command> p) {
		this.parent = p;
	}

	public ParseTreeNode<Command> getParent() {
		return this.parent;
	}

	public double getCommandValue() {

		return ((command.Command) this.command).getValue();
	}

	public void setCommandValue(double d) {
		((command.Command) this.command).setValue(d);
	}

}
