package view;

import java.util.HashMap;
import java.util.Map;

import view.props.Properties;
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
	private static final double OFFSET_SPACE = 40;
	private static final double CONSOLE_X = 600;
	private static final double CONSOLE_Y = 50;

	protected Stage myStage;
	private Scene myScene;
	private Group myRoot;
	
	private int myWindowWidth, myWindowHeight;
	
	private History myHistory;
	private ConsoleUI myConsoleUI;
	private Buttons myButtonsOnGUI;
	private TurtleScene myTurtleScene;
	private Properties myProps;
	
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
		myButtonsOnGUI.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + OFFSET_SPACE);
		
		myTurtleScene = new TurtleScene();
		myTurtleScene.setTranslateX(CONSOLE_X + myConsoleUI.getWidth() + OFFSET_SPACE);
		myTurtleScene.setTranslateY(CONSOLE_Y);
		
		myProps = new Properties();
		myProps.setTranslateX(CONSOLE_X + myConsoleUI.getWidth() + OFFSET_SPACE);
		myProps.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + OFFSET_SPACE);
		
		myHistory = new History(myConsoleUI);
		myHistory.setTranslateX(CONSOLE_X - OFFSET_SPACE - myHistory.getPrefWidth());
		myHistory.setTranslateY(CONSOLE_Y);
		
		myRoot.getChildren().addAll(myConsoleUI, myButtonsOnGUI, myTurtleScene, myProps, myHistory);
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
