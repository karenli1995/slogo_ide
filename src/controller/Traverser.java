package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import command.CommandInterface;
import model.data.Data;
import model.data.ForObserverInterface;


public class Traverser {
    private Queue<ParseTreeNode<CommandInterface>> commandQueue;
    private Data data;

    public Double traverse (List<ParseTreeNode<CommandInterface>> node, Data allData) {
        data = allData;
        commandQueue = new LinkedList<ParseTreeNode<CommandInterface>>();
        if (node.get(0) == null) {
            return -1.0;
        }
        else {
            for (ParseTreeNode<CommandInterface> s : node) {
                this.iterateTreePostOrder(s, allData);
            }
            Double value = executeCommands();
            allData.setCommandValue(value);
            return value;
        }

    }

    public void iterateTreePostOrder (ParseTreeNode<CommandInterface> node,
                                      ForObserverInterface allData) {
        if (node != null) {
            for (List<ParseTreeNode<CommandInterface>> childNode : node.getChildren()
                    .getNodeList()) {
                this.iterateTreePostOrder(childNode, allData);
            }
            commandQueue.add(node);

        }
        else {
            allData.setErrorMessage("No Argument");
        }

    }

    private void iterateTreePostOrder (List<ParseTreeNode<CommandInterface>> node,
                                       ForObserverInterface allData) {
        if (node == null) {
            return;
        }

        for (ParseTreeNode<CommandInterface> subList : node) {
            for (List<ParseTreeNode<CommandInterface>> childNode : subList.getChildren()
                    .getNodeList()) {
                this.iterateTreePostOrder(childNode, allData);
            }
        }
        if (node.size() == 1) {
            if (!checkListStartEnd(node.get(0))) {
                commandQueue.add(node.get(0));
            }
        }
    }

    public double executeCommands () {
        Double commandValue = null;
        while (!commandQueue.isEmpty()) {
            ParseTreeNode<CommandInterface> tempNode = commandQueue.poll();
            tempNode.getCommand().addObserver(data);
            if (!checkListStartEnd(tempNode)) {
                commandValue = tempNode.getCommand().execute(tempNode.getChildren());
            }

        }
        return commandValue;
    }

    public boolean checkListStartEnd (ParseTreeNode<CommandInterface> node) {
        return (node.getCommand().getClass().getSimpleName().equals("ListEnd") ||
                node.getCommand().getClass().getSimpleName().equals("ListStart"));
    }

}
