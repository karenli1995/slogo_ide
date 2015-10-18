package view;

import java.util.Optional;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.console.AvailableUserCommands;
import view.console.ConsoleUI;
import view.console.History;
import view.props.Properties;
import view.scene.TurtleScene;
import view.settings.LangDialog;
import view.settings.MenuPanel;

public class GUIManager extends BorderPane {
	private static final String TITLE = "SLogo";
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	public static final String STYLESHEET = "default.css";

	protected Stage myStage;
	private Scene myScene;
	private Group myRoot;

	private ModelController myModelController;
	private AvailableUserCommands myAvailableUserCommands;
	private History myHistory;
	private ConsoleUI myConsoleUI;
	private TurtleScene myTurtleScene;
	private Properties myProps;
	private MenuPanel myMenu;
	public ResourceBundle myResource;

	/**
	 * Instantiates the entire view
	 * 
	 * @param stage
	 * @param modelController
	 */
	public GUIManager(Stage stage, ModelController modelController) {
		langInput();
		myStage = stage;
		myModelController = modelController;
		Scene scene = init((int) stage.getWidth(), (int) stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);

		this.prefHeightProperty().bind(scene.heightProperty());
		this.prefWidthProperty().bind(scene.widthProperty());

		addTopPane();
		addBottomPane(scene);
		addCenterPane();
		addRightPane(scene);
		addLeftPane(scene);

		myRoot.getChildren().addAll(this);
		stage.show();
	}

	/**
	 * Prompts user to choose a language for the IDE platform
	 */
	private void langInput() {
		LangDialog lang = new LangDialog();
		Optional<ResourceBundle> resource = lang.showAndWait();
		if (resource.isPresent()) {
			myResource = resource.get();
		}
	}

	/**
	 * The next 5 methods instantiate different parts of the view: Menu Console
	 * Scene Properties History/User Commands
	 */
	private void addTopPane() {
		myMenu = new MenuPanel(myStage, myModelController, myResource);
		this.setTop(myMenu);
	}

	private void addBottomPane(Scene scene) {
		myConsoleUI = new ConsoleUI(scene, myModelController, this, myResource);
		this.setBottom(myConsoleUI);
	}

	private void addCenterPane() {
		myTurtleScene = new TurtleScene(myModelController, myResource);
		this.setCenter(myTurtleScene);
	}

	private void addRightPane(Scene scene) {
		myProps = new Properties(scene, myTurtleScene, this, myResource, myStage);
		this.setRight(myProps);
	}

	private void addLeftPane(Scene scene) {
		GridPane histAndUser = new GridPane();
		myHistory = new History(myConsoleUI, scene);
		histAndUser.add(myHistory, 1, 1);
		myAvailableUserCommands = new AvailableUserCommands(myConsoleUI, scene);
		histAndUser.add(myAvailableUserCommands, 2, 1);
		this.setLeft(histAndUser);
	}

	/**
	 * Gets the root of the scene.
	 * 
	 * @return
	 */
	public Group getRoot() {
		return myRoot;
	}

	/**
	 * Sets the language of the IDE platform.
	 * 
	 * @param lang
	 */
	public void setLanguage(String lang) {
		myResource = ResourceBundle.getBundle("resources.languages/" + lang);
		System.out.print(myResource.getString("RUN"));
	}

	public TurtleScene getTurtScene() {
		return myTurtleScene;
	}

	public History getMyHistory() {
		return myHistory;
	}
	
	public AvailableUserCommands getMyUserCommands(){
		return myAvailableUserCommands;
	}

	/**
	 * Initialize the window
	 * 
	 * @param width
	 *            The width of the window
	 * @param height
	 *            The height of the window
	 * @return the Scene that was initialized
	 */
	private Scene init(int width, int height) {
		myRoot = new Group();
		myScene = new Scene(myRoot, width, height, Color.AZURE);
		// myScene.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
		return myScene;
	}

}
