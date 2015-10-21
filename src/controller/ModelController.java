package controller;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import javafx.stage.Stage;
import model.Data;
import model.MathCommand;
import model.Scene;
import view.GUIManager;
import view.console.Prompt;
import view.props.CurrentTurtleState;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;

public class ModelController extends ControlFunctions {

	private List<Data> myDataList = new ArrayList<Data>();
//	private Data myAllData;
	private Scene myScene;
	private Parser myParser;
	private GUIManager myGuiManager;
	private Traverser myTraverser;
	private List<ParseTreeNode<Command>> myTree;

	public ModelController(Stage stage) {
		super();
		Data myAllData = new Data();
		myDataList.add(myAllData);
		myGuiManager = new GUIManager(stage, this);
		myParser = new Parser();
		myTraverser = new Traverser();
		addObservable();
	}

	/**
	 * The controller connects the observables and observers between the front
	 * end and back end.
	 */
	public void addObservable() {
		TurtleScene turtScene = myGuiManager.getTurtScene();
//		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().getCurrTab();
//		int id = turtScene.getIdOfTab();
//		Data scene = getData(id);
//		scene.addObserver(currSceneTab);

		//check
		CurrentTurtleState currTurtState = myGuiManager.getMyCurrTurtState();
//		scene.addObserver(currTurtState);
		for(int i=0; i<myDataList.size(); i++) {
			myDataList.get(i).addObserver(turtScene.getMyTabs().get(i));
			myDataList.get(i).addObserver(currTurtState);
		}
		
		
		MathCommand values = myTraverser.getMathCommand();
		Prompt prompt = myGuiManager.getMyPrompt();
		values.addObserver(prompt);
		
	}


	public GUIManager getGuiManager() {
		return myGuiManager;
	}

	/**
	 * Sets the Data object, passing information to Data from the front-end to
	 * the back-end.
	 */
	public void setData(int id, Data data) {
		myDataList.add(id, data);
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

	public void addData(Data data){
		myDataList.add(data);
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
	public Data traverse(int id) {
		Data myCurrData = myDataList.get(id);
		myCurrData = myTraverser.traverse(myTree, myCurrData);
		myDataList.add(id, myCurrData);
		return myCurrData;
	}

}
