package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import command.CommandInterface;
import model.Data;

public class Traverser {
	private Queue<ParseTreeNode<CommandInterface>> commandQueue;
	private Stack<ParseTreeNode<CommandInterface>> listEndStack;

	public Data traverse(List<ParseTreeNode<CommandInterface>> node, Data allData) {
		listEndStack = new Stack<ParseTreeNode<CommandInterface>>();
		commandQueue = new LinkedList<ParseTreeNode<CommandInterface>>();
		for (ParseTreeNode<CommandInterface> s : node) {
			this.iterateTreePostOrder(s);
		}

		this.executeCommands();

		return allData;
	}

	public void iterateTreePostOrder(ParseTreeNode<CommandInterface> node) {
		if (node == null)
			return;

		if (node.getClass().getSimpleName().equals("ListEnd")) {

		}
		for (ParseTreeNode<CommandInterface> childNode : node.getChildren()) {
			this.iterateTreePostOrder(childNode);
		}

		commandQueue.add(node);
	}

	public void executeCommands() {

		while (!commandQueue.isEmpty()) {
			ParseTreeNode<CommandInterface> tempNode = commandQueue.poll();
			Double commandValue= tempNode.getCommand().execute(tempNode.getChildren());
		}

	}

}
