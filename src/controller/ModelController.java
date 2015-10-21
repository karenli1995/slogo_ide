package controller;

import java.util.List;

import command.Command;
import javafx.stage.Stage;
import model.Data;
import model.SlogoObjects;
import view.GUIManager;
import view.console.Prompt;
import view.props.CurrentTurtleState;
import view.scene.TurtleSceneTab;

public class ModelController {

	private Data myAllData;
	private Parser myParser;
	private GUIManager myGuiManager;
	private Traverser myTraverser;
	private List<ParseTreeNode<Command>> myTree;

	public ModelController(Stage stage) {
		myAllData = new Data();
		myGuiManager = new GUIManager(stage, this);
		myParser = new Parser();
		myTraverser = new Traverser();
		addObservable();
	}

	/**
	 * The controller connects the observables and observers between the front
	 * end and back end.
	 */
	private void addObservable() {
		Data scene = getData();
		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().getCurrTab();
		scene.addObserver(currSceneTab);
		
		//check
		CurrentTurtleState currTurtState = myGuiManager.getMyCurrTurtState();
		scene.addObserver(currTurtState);
		
//		Command values = 
//		Prompt prompt = myGuiManager.getMyPrompt();
//		scene.addObserver(prompt);
		
	}


	public GUIManager getGuiManager() {
		return myGuiManager;
	}

	/**
	 * Sets the Data object, passing information to Data from the front-end to
	 * the back-end.
	 */
	public void setData(Data data) {
		myAllData = data;
	}

	/**
	 * Gets the Data object, containing information to be passed from back-end
	 * to front-end.
	 *
	 * @return
	 */
	public Data getData() {
		return myAllData;
	}

	/**
	 * Gets Parser which parses the commands
	 *
	 * @return Parser
	 */
	public Parser getParser() {
		return myParser;
	}

	/**
	 * Parses the commands
	 *
	 * @param s
	 */
	public void parse(String s) {
		myTree = myParser.parse(s);
	}

	/**
	 * Traverses command tree
	 *
	 * @return
	 */
	public Data traverse() {
		myAllData = myTraverser.traverse(myTree, myAllData);
		return myAllData;
	}

}
