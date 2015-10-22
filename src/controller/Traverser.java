package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import command.CommandInterface;
import model.Data;


public class Traverser {
	private Queue<ParseTreeNode<CommandInterface>> commandQueue;

	public Data traverse(List<ParseTreeNode<CommandInterface>> node, Data allData) {
		commandQueue = new LinkedList<ParseTreeNode<CommandInterface>>();
		for (ParseTreeNode<CommandInterface> s : node) {
			this.iterateTreePostOrder(s);
		}

		allData.setCommandValue(this.executeCommands());

		return allData;
	}

	public void iterateTreePostOrder(ParseTreeNode<CommandInterface> node) {
		System.out.println(node.getNumberOfChildren());
		for (List<ParseTreeNode<CommandInterface>> childNode : node.getChildren()) {
			System.out.println(childNode.size());
			this.iterateTreePostOrder(childNode);
		}

		commandQueue.add(node);
	}

	public void iterateTreePostOrder(List<ParseTreeNode<CommandInterface>> node) {
		if (node == null)
			return;
		
		for (ParseTreeNode<CommandInterface> subList : node) {
			for (List<ParseTreeNode<CommandInterface>> childNode : subList.getChildren()) {
				this.iterateTreePostOrder(childNode);
			}
		}
		if(node.size() == 1){
			commandQueue.add(node.get(0));
		}
	}

	public double executeCommands() {
		Double commandValue = null;
		while (!commandQueue.isEmpty()) {
			ParseTreeNode<CommandInterface> tempNode = commandQueue.poll();

			commandValue = tempNode.getCommand().execute(tempNode.getChildren());


		}
		return commandValue;
	}

}
