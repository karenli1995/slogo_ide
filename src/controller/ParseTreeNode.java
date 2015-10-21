package controller;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;

public class ParseTreeNode<Command> {

	private Command command;

	//TODO make this a class
	private List<ParseTreeNode<Command>> children;
	private List<ParseTreeNode<CommandInterface>> sth;
	private ParseTreeNode parent = this;

	public ParseTreeNode() {
		super();
		children = new ArrayList<ParseTreeNode<Command>>();
	}

	public ParseTreeNode(Command command) {
		this();
		setCommand(command);

	}

	public List<ParseTreeNode<Command>> getChildren() {
		return this.children;
	}

	public int getNumberOfChildren() {
		return getChildren().size();
	}

	public boolean hasChildren() {
		return (getNumberOfChildren() > 0);
	}

	public void setChildren(List<ParseTreeNode<Command>> children) {
		this.children = children;
	}

	public void addChild(ParseTreeNode<Command> child) {
		children.add(child);
		child.setParent(this);
	}

	public void addChildAt(int index, ParseTreeNode<Command> child) throws IndexOutOfBoundsException {
		children.add(index, child);
	}

	public void removeChildren() {
		this.children = new ArrayList<ParseTreeNode<Command>>();
	}

	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		children.remove(index);
	}

	public ParseTreeNode<Command> getChildAt(int index) throws IndexOutOfBoundsException {
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

	public double getCommandValue(){

		return ((command.Command) this.command).getValue();
	}

	public void setCommandValue(double d){
		((command.Command) this.command).setValue(d);
	}

}
