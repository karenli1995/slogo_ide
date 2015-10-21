package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import command.Command;

public class ParseTreeNode<Command> {

	private Command command;
	//TODO make this a class
	private ParseTreeChildren children;
	private ParseTreeNode<Command> parent = this;

	public ParseTreeNode() {
		super();
		children = new ParseTreeChildren();
	}

	public ParseTreeNode(Command command) {
		this();
		setCommand(command);
	}

	public ParseTreeChildren getChildren() {
		return this.children;
	}

	public int getNumberOfChildren() {
		return children.getChildList().size();
	}

	public boolean hasChildren() {
		return (getNumberOfChildren() > 0);
	}

	public void setChildren(ParseTreeChildren children) {
		this.children = children;
	}

	public void addChild(List<ParseTreeNode<command.Command>> child) {
		children.getChildList().add(child);
	}

	public void addChildAt(int index, List<ParseTreeNode<command.Command>> child) throws IndexOutOfBoundsException {
		children.getChildList().add(index, child);
	}

	public void removeChildren() {
		this.children = new ParseTreeChildren();
	}

	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		children.getChildList().remove(index);
	}

	public List<ParseTreeNode<command.Command>> getChildAt(int index) throws IndexOutOfBoundsException {
		return children.getChildList().get(index);
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
		return parent;
	}

}
