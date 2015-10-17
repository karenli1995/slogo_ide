package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import command.Command;
import model.Data;
import model.Location;

public class Traverser {
	private Queue<ParseTreeNode<Command>> commandQueue;
	private Stack<ParseTreeNode<Command>> listEndStack;
	
	public Data traverse(List<ParseTreeNode<Command>> node, Data allData) {
		listEndStack = new Stack<ParseTreeNode<Command>>();
		commandQueue = new LinkedList<ParseTreeNode<Command>>();
		for (ParseTreeNode<Command> s : node) {
			this.iterateTreePostOrder(s);
		}
		this.executeCommands(allData);

		return allData;
	}

	public void iterateTreePostOrder(ParseTreeNode<Command> node) {
		if (node == null)
			return;

		if(node.getClass().getSimpleName().equals("ListEnd")){
			
		}
		for (ParseTreeNode<Command> childNode : node.getChildren()) {
			this.iterateTreePostOrder(childNode);
		}

		commandQueue.add(node);
	}

	public Data executeCommands(Data allData) {
		while (!commandQueue.isEmpty()) {
			ParseTreeNode<Command> tempNode = commandQueue.poll();
			allData = tempNode.getCommand().execute(tempNode.getChildren(), allData);
		}

		return allData;
	}

}
