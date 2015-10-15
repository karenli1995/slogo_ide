package view;

import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.props.Properties;

public class GUIManager extends BorderPane {
	private static final String TITLE = "SLogo";
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final String STYLESHEET = "default.css";
	private static final double OFFSET_SPACE = 40;

	protected Stage myStage;
	private static Scene myScene;
	private Group myRoot;

	private int myWindowWidth, myWindowHeight;

	private History myHistory;
	private ConsoleUI myConsoleUI;
	private Buttons myButtonsOnGUI;
	private TurtleScene myTurtleScene;
	private Properties myProps;
	private AvailableUserCommands myAvailableUserCommands;

	public GUIManager(Stage stage, ModelController controller){
		myStage = stage;
		Scene scene = init((int)stage.getWidth(), (int)stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);
		
		this.prefHeightProperty().bind(scene.heightProperty());
        this.prefWidthProperty().bind(scene.widthProperty());


		myConsoleUI = new ConsoleUI(scene, controller);
		//myConsoleUI.setTranslateX(CONSOLE_X);
		//myConsoleUI.setTranslateY(CONSOLE_Y);
		this.setBottom(myConsoleUI);
		
		GridPane histAndUser = new GridPane();
		//myButtonsOnGUI = new Buttons(myConsoleUI, controller);
		//myButtonsOnGUI.setTranslateX(CONSOLE_X);
		//myButtonsOnGUI.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + OFFSET_SPACE);
		//this.setTop(myButtonsOnGUI);

		myTurtleScene = new TurtleScene();
		//myTurtleScene.setTranslateX(CONSOLE_X + myConsoleUI.getWidth() + OFFSET_SPACE);
		//myTurtleScene.setTranslateY(CONSOLE_Y);
		this.setCenter(myTurtleScene);

		myProps = new Properties(scene);
		//myProps.setTranslateX(CONSOLE_X + myConsoleUI.getWidth() + OFFSET_SPACE);
		//myProps.setTranslateY(CONSOLE_Y + myConsoleUI.getHeight() + OFFSET_SPACE);
		this.setRight(myProps);

		myHistory = new History(myConsoleUI, scene);
		//myHistory.setTranslateX(CONSOLE_X - OFFSET_SPACE - myHistory.getPrefWidth());
		//myHistory.setTranslateY(CONSOLE_Y);
		histAndUser.add(myHistory, 1, 1);
		
		myAvailableUserCommands =  new AvailableUserCommands(myConsoleUI, scene);
		histAndUser.add(myAvailableUserCommands, 2, 1);

		this.setLeft(histAndUser);

		myRoot.getChildren().addAll(this);
		stage.show();
	}
	public Group getRoot(){return myRoot;}

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
