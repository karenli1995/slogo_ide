package view;

import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.props.Properties;

public class GUIManager extends BorderPane {
	private static final String TITLE = "SLogo";
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private static final String STYLESHEET = "default.css";
//    private static final double SCENE_WIDTH = Screen.getPrimary().getVisualBounds().getWidth()*3/7;
//	private static final double SCENE_HEIGHT = Screen.getPrimary().getVisualBounds().getWidth()*9/20;

	protected Stage myStage;
	private static Scene myScene;
	private Group myRoot;

	private int myWindowWidth, myWindowHeight;

	private ConsoleUI myConsoleUI;
	private Buttons myButtonsOnGUI;
	private TurtleScene myTurtleScene;
	private Properties myProps;

	public GUIManager(Stage stage, ModelController modelController){
		myStage = stage;
		Scene scene = init((int)stage.getWidth(), (int)stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);
		
		this.prefHeightProperty().bind(scene.heightProperty());
        this.prefWidthProperty().bind(scene.widthProperty());


		myConsoleUI = new ConsoleUI(scene, modelController);
		this.setBottom(myConsoleUI);
		
		GridPane histAndUser = new GridPane();
		History myHistory = new History(myConsoleUI, scene);
		histAndUser.add(myHistory, 1, 1);
		AvailableUserCommands myAvailableUserCommands =  new AvailableUserCommands(myConsoleUI, scene);
		histAndUser.add(myAvailableUserCommands, 2, 1);

		this.setLeft(histAndUser);
		

		myTurtleScene = new TurtleScene(modelController);
		this.setCenter(myTurtleScene);

		myProps = new Properties(scene, myTurtleScene);
		this.setRight(myProps);

		myRoot.getChildren().addAll(this);
		stage.show();
	}
	
	public Group getRoot(){
		return myRoot;
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
//        myScene.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
		return myScene;
	}

}
