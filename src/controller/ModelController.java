package controller;

import javafx.stage.Stage;
import model.Data;
import model.MathCommand;
import model.SlogoScene;
import view.GUIManager;
import view.console.Prompt;
import view.props.CurrentTurtleState;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;

public class ModelController extends ControlFunctions {

	private SlogoScene myScene;
	private GUIManager myGuiManager;

	public ModelController(Stage stage) {
		super();
		myScene = new SlogoScene();
		myGuiManager = new GUIManager(stage, this);
		
		TurtleScene turtScene = myGuiManager.getTurtScene();
//		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().getCurrTab();
		
		addObservable(turtScene, myScene);
	}
	
	public ModelController(Stage stage, GUIManager guiManager, SlogoScene scene){
		super();
		myScene = scene;
		Data newData = new Data();
		myScene.setData(myScene.getAllData().size(), newData);
		
		myGuiManager = guiManager;
		TurtleScene turtScene = myGuiManager.getTurtScene();
		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().createNewTab(this);
		
		addObservable(turtScene, myScene);
	}

	/**
	 * The controller connects the observables and observers between the front
	 * end and back end.
	 */
	public void addObservable(TurtleScene turtleScene, SlogoScene scene) {
//		TurtleScene turtScene = myGuiManager.getTurtScene();
//		TurtleSceneTab currSceneTab = myGuiManager.getTurtScene().getCurrTab();
//		int id = turtScene.getIdOfTab();
//		SlogoScene scene = myScene; //set id

		CurrentTurtleState currTurtState = myGuiManager.getMyCurrTurtState();
		
		scene.addObserver(turtleScene);
		scene.addObserver(currTurtState);
		
		Prompt prompt = myGuiManager.getMyPrompt();
		scene.addObserver(prompt);
		
	}


	public GUIManager getGuiManager() {
		return myGuiManager;
	}
	
	public SlogoScene getMyScene(){
		return myScene;
	}

}