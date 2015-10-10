package view;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIManager {
	private static final String TITLE = "SLogo";
	private static final int BUTTON_AREA_WIDTH = 400;
	private static final double BUTTON_HEIGHT = 40;
	private static final double CONSOLE_X = 300;
	private static final double CONSOLE_Y = 10;
	private static final double TURTLE_PROPS_X = 300;
	private static final double TURTLE_PROPS_Y = 10;

	protected Stage myStage;
	private Scene myScene;
	private Group myRoot;
	
	private int myWindowWidth, myWindowHeight;
	
	private ConsoleUI myConsoleUI;
	private Buttons myButtonsOnGUI;
	private TurtleScene myTurtleScene;
	private TurtleProps myTurtleProps;
	
	public GUIManager(Stage stage){
		myStage = stage;
		Scene scene = init((int)stage.getWidth(), (int)stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);
		
		myConsoleUI = new ConsoleUI();
		myConsoleUI.setTranslateX(CONSOLE_X);
		myConsoleUI.setTranslateY(CONSOLE_Y);
		
		myButtonsOnGUI = new Buttons(myConsoleUI);
		myButtonsOnGUI.setTranslateX(CONSOLE_X);
		myButtonsOnGUI.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + BUTTON_HEIGHT);
		
		myTurtleScene = new TurtleScene();
		myTurtleScene.setTranslateX(CONSOLE_X + myConsoleUI.getWidth());
		myTurtleScene.setTranslateY(CONSOLE_Y);
		
		myTurtleProps = new TurtleProps();
		myTurtleProps.setTranslateX(CONSOLE_X + myConsoleUI.getWidth());
		myTurtleProps.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + BUTTON_HEIGHT);
		
		myRoot.getChildren().addAll(myConsoleUI, myButtonsOnGUI, myTurtleScene, myTurtleProps);
		stage.show();
	}
	
	
	/**
	 * Initialize the window
	 * @param width The width of the window
	 * @param height The height of the window
	 * @return the Scene that was initialized
	 */
	private Scene init(int width, int height) {
		myWindowWidth = width;
		myWindowHeight = height;
		myRoot = new Group();
		myScene = new Scene(myRoot,width,height,Color.AZURE);
		return myScene;
	}
	
}
