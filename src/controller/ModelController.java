package controller;

import java.util.List;

import command.Command;
import javafx.scene.Group;
import javafx.stage.Stage;
import model.Data;
import model.SlogoObjects;
import model.commandTester;
import view.GUIManager;
import view.TurtleSceneTab;

public class ModelController {

	private Data allData;
	private Parser parser;
	private GUIManager myGuiManager;
	private commandTester commandtester;
	private Traverser traverser;
	private List<ParseTreeNode<Command>> tree;

	public ModelController(Stage stage) {
		this.initData();
		myGuiManager = new GUIManager(stage, this);
		parser = new Parser();
		traverser = new Traverser();
		
		//adding observer and observable
		SlogoObjects turtObj = getData().getTurtle(0);
		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().getCurrTab();
		turtObj.addObserver(currSceneTab);
		
		//commandtester = new commandTester(root, this);// for testing only

	}
	
	public GUIManager getGuiManager(){
		return myGuiManager;
	}
	
	public void setData(Data data) {
		allData = data;
	}

	public Data getData() {
		return allData; 
	}

	public Parser getParser() {
		return parser;
	}

	private void initData() {
		allData = new Data();
	}

	public void parse(String s) {
		tree = parser.parse(s);
	}

	public Data traverse(){
		allData = traverser.traverse(tree, allData);
		return allData;
	}
	
}
