package controller;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Data;
import model.MathCommand;
import model.SlogoObjects;
import model.SlogoScene;
import view.GUIManager;
import view.console.Prompt;
import view.props.CurrentTurtleState;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;

public class ModelController extends ControlFunctions {
	private static final int FRAMES_PER_SECOND = 10;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	
	private Timeline myAnimation;
	private SlogoScene myScene;
	private GUIManager myGuiManager;

	public ModelController(Stage stage) {
		super();
		myScene = new SlogoScene();
		myGuiManager = new GUIManager(stage, this);
		
		TurtleScene turtScene = myGuiManager.getTurtScene();
		
		addObservable(turtScene, myScene);
		
//		myGuiManager.getTurtScene().getCurrTab().getSlogoImage(0).setScreenLoc(0, 0);
//		createAnimation();
	}
	
	public ModelController(Stage stage, GUIManager guiManager, SlogoScene scene){
		super();
		myScene = scene;
		Data newData = new Data();
		List<SlogoObjects> allTurtles = newData.getAllTurtles();
		for(int i = 0; i<allTurtles.size(); i++){
			SlogoObjects turtle = allTurtles.get(i);
			turtle.getTrail().setPoint(new Point2D(0,0));
			newData.setTurtle(i, turtle);
		}
		myScene.getAllData().add(newData);
		
		myGuiManager = guiManager;
		TurtleScene turtScene = myGuiManager.getTurtScene();
		TurtleSceneTab currSceneTab = turtScene.createNewTab(this);
		
		addObservable(turtScene, myScene);
//		createAnimation();
	}
	
	/**
	 * Create the animation and timeline.
	 */
//	private void createAnimation() {
//		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> myManager.step());
//		myAnimation = new Timeline();
//		myAnimation.setCycleCount(Timeline.INDEFINITE);
//		myAnimation.getKeyFrames().add(frame);
//	}

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