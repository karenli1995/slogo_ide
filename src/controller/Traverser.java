package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import command.CommandInterface;
import model.Data;
import model.ForObserverInterface;


public class Traverser {
    private Queue<ParseTreeNode<CommandInterface>> commandQueue;
    private ForObserverInterface allData;


    public Double traverse (List<ParseTreeNode<CommandInterface>> node, ForObserverInterface allData) {
        commandQueue = new LinkedList<ParseTreeNode<CommandInterface>>();
        this.allData = allData;
        if (node.get(0) == null) {
            return -1.0;
        }
        else {
            for (ParseTreeNode<CommandInterface> s : node) {
                this.iterateTreePostOrder(s);
            }
            Double value = this.executeCommands();
            allData.setCommandValue(value);
            return value;
        }

    }

    public void iterateTreePostOrder (ParseTreeNode<CommandInterface> node) {
        if (node != null) {
            for (List<ParseTreeNode<CommandInterface>> childNode : node.getChildren()
                    .getNodeList()) {
                this.iterateTreePostOrder(childNode);
            }
            commandQueue.add(node);

        } else{
            allData.setErrorMessage("No Argument");
        }

    }

    private void iterateTreePostOrder (List<ParseTreeNode<CommandInterface>> node) {
        if (node == null)
            return;

        for (ParseTreeNode<CommandInterface> subList : node) {
            for (List<ParseTreeNode<CommandInterface>> childNode : subList.getChildren()
                    .getNodeList()) {
                this.iterateTreePostOrder(childNode);
            }
        }
        if (node.size() == 1) {
            commandQueue.add(node.get(0));
        }
    }

    public double executeCommands () {
        Double commandValue = null;
        while (!commandQueue.isEmpty()) {
            ParseTreeNode<CommandInterface> tempNode = commandQueue.poll();
            tempNode.getCommand().addObserver(new Data());
            commandValue = tempNode.getCommand().execute(tempNode.getChildren());

        }
        return commandValue;
    }

}
