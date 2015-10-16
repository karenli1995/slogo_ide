package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import command.Command;
import model.Data;

public class Traverser {
	private Queue<ParseTreeNode<Command>> commandQueue;

	public Data traverse(List<ParseTreeNode<Command>> node, Data allData) {
		commandQueue = new LinkedList<ParseTreeNode<Command>>();
		for (ParseTreeNode<Command> s : node) {
			this.iterateTreeInOrder(s);
		}

		return allData;
	}

	public void iterateTreeInOrder(ParseTreeNode<Command> node) {
		if (node == null)
			return;

		for (ParseTreeNode<Command> childNode : node.getChildren()) {
			this.iterateTreeInOrder(childNode);
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
