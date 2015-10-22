package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import command.Command;
import controller.ParseTreeNode;
import controller.Parser;
import controller.Traverser;

public class SlogoScene extends Observable{

	private List<Data> myDataList = new ArrayList<Data>();
	private Traverser myTraverser;
	private List<ParseTreeNode<Command>> myTree;
	private Parser myParser;
	
	public SlogoScene(){
		Data myAllData = new Data();
//		myDataList.add(myAllData);
		setData(myDataList.size(), myAllData);
		
		myParser = new Parser();
		myTraverser = new Traverser();
	}

	
	/**
	 * Sets the Data object, passing information to Data from the front-end to
	 * the back-end.
	 */
	public void setData(int id, Data data) {
		myDataList.add(id, data);
		setChanged();
		notifyObservers();
//		myAllData = data;
	}

	/**
	 * Gets the Data object, containing information to be passed from back-end
	 * to front-end.
	 *
	 * @return
	 */
	public Data getData(int id) {
		return myDataList.get(id);
	}
	
	public List<Data> getAllData() {
		return myDataList;
	}
	
	/**
	 * Traverses command tree
	 *
	 * @return
	 */
	public Data traverse(int id) {
		Data myCurrData = myDataList.get(id);
		myCurrData = myTraverser.traverse(myTree, myCurrData);
		setData(id, myCurrData);
//		myDataList.add(id, myCurrData);
		return myCurrData;
	}
	
	/**
	 * Parses the commands
	 *
	 * @param s
	 */
	public void parse(String s) {
		myTree = myParser.parse(s);
	}
	
	public Parser getParser() {
		return myParser;
	}
	
	public Traverser getTraverser(){
		return myTraverser;
	}
}
