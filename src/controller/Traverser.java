package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import command.CommandInterface;
import model.Data;


public class Traverser {
	private Queue<ParseTreeNode<CommandInterface>> commandQueue;
	Data allData;
	public Data traverse(List<ParseTreeNode<CommandInterface>> node, Data allData) {
		commandQueue = new LinkedList<ParseTreeNode<CommandInterface>>();
		for (ParseTreeNode<CommandInterface> s : node) {
			this.iterateTreePostOrder(s);
		}

		allData.setCommandValue(this.executeCommands());
this.allData=allData;
		return allData;
	}



	public void iterateTreePostOrder(ParseTreeNode<CommandInterface> node) {
		for (List<ParseTreeNode<CommandInterface>> childNode : node.getChildren().getNodeList()) {
			System.out.println(childNode.size());
			this.iterateTreePostOrder(childNode);
		}

		commandQueue.add(node);
	}

	private void iterateTreePostOrder(List<ParseTreeNode<CommandInterface>> node) {
		if (node == null)
			return;

		for (ParseTreeNode<CommandInterface> subList : node) {
			for (List<ParseTreeNode<CommandInterface>> childNode : subList.getChildren().getNodeList()) {
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
			tempNode.getCommand().addObserver(new Data());
			commandValue = tempNode.getCommand().execute(tempNode.getChildren());


		}
		return commandValue;
	}

}
