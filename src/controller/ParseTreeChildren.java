package controller;

import java.util.ArrayList;
import java.util.List;
import command.Command;
import command.CommandInterface;

public class ParseTreeChildren {
	private List<List<ParseTreeNode<CommandInterface>>> nodeList;


	private ParseTreeNode<CommandInterface> parent;
	
	public ParseTreeChildren(ParseTreeNode<CommandInterface> node){
		parent = node;
		nodeList = new ArrayList<List<ParseTreeNode<CommandInterface>>>();
	}
	
	public int getSize(){
		return nodeList.size();
	}
	
	public void addChildList(List<ParseTreeNode<CommandInterface>> child) {
		nodeList.add(child);

	}

	public void addChildListAt(int index, List<ParseTreeNode<CommandInterface>> child) throws IndexOutOfBoundsException {
		nodeList.add(index, child);
	}

	public void removeChildListAt(int index) throws IndexOutOfBoundsException {
		nodeList.remove(index);
	}

	public List<ParseTreeNode<CommandInterface>> getChildListAt(int index) {
		return nodeList.get(index);
	}
	
	public List<List<ParseTreeNode<CommandInterface>>> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<List<ParseTreeNode<CommandInterface>>> nodeList) {
		this.nodeList = nodeList;
	}
	
	public ParseTreeNode<CommandInterface> getNode(int a, int b){
		return nodeList.get(a).get(b);
	}
	
	public double getCommandValue(int a, int b){
		return getNode(a, b).getCommandValue();
	}
	
	public String getCommandName(int a, int b){
		return getNode(a, b).getCommandName();
	}
	
	public Command getCommand(int a, int b){
	    return getNode(a, b).getCommand();
	}
}
