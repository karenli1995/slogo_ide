package view;

import java.util.Optional;
import java.util.ResourceBundle;

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
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final String STYLESHEET = "default.css";

	protected Stage myStage;
	private static Scene myScene;
	private Group myRoot;

	private int myWindowWidth, myWindowHeight;
	
	private ModelController myModelController;
	private AvailableUserCommands myAvailableUserCommands;
	private History myHistory;
	private ConsoleUI myConsoleUI;
	private TurtleScene myTurtleScene;
	private Properties myProps;
	private MenuPanel myMenu;
	public ResourceBundle myResource;

	public GUIManager(Stage stage, ModelController modelController){
		langInput();
		myStage = stage;
		myModelController = modelController;
		Scene scene = init((int)stage.getWidth(), (int)stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);
		
		this.prefHeightProperty().bind(scene.heightProperty());
        this.prefWidthProperty().bind(scene.widthProperty());
		
        myMenu = new MenuPanel(myStage, myModelController, myResource);
        this.setTop(myMenu);
        addBottomPane(myModelController, scene);
		addCenterPane(myModelController);
		addRightPane(scene);
		addLeftPane(scene);

		myRoot.getChildren().addAll(this);
		stage.show();
	}
	
	//check this method
//	public void updateControllerForView(ModelController controller){
//		myModelController = controller;
//		myTurtleScene.setController(myModelController);
//		//myTurtleScene.setTurtle();
//	}

	private void langInput() {
		LangDialog lang = new LangDialog();
		Optional<ResourceBundle> resource = lang.showAndWait();
		if(resource.isPresent()){
			myResource = resource.get();
		}
	}

	private void addBottomPane(ModelController controller, Scene scene) {
		myConsoleUI = new ConsoleUI(scene, controller, this, myResource);
		this.setBottom(myConsoleUI);
	}

	private void addCenterPane(ModelController controller) {
		myTurtleScene = new TurtleScene(controller, myResource);
		this.setCenter(myTurtleScene);
	}

	private void addRightPane(Scene scene) {
		myProps = new Properties(scene, myTurtleScene, this, myResource);
		this.setRight(myProps);
	}
	
	private void addLeftPane(Scene scene) {
		GridPane histAndUser = new GridPane();
		myHistory = new History(myConsoleUI, scene);
		histAndUser.add(myHistory, 1, 1);
		myAvailableUserCommands =  new AvailableUserCommands(myConsoleUI, scene);
		histAndUser.add(myAvailableUserCommands, 2, 1);
		this.setLeft(histAndUser);
	}
	
	public Group getRoot(){
		return myRoot;
	}
	
	public void setLanguage(String lang){
		myResource = ResourceBundle.getBundle("resources.languages/" + lang);
		System.out.print(myResource.getString("RUN"));
		
	}
	
	public TurtleScene getTurtScene(){
		return myTurtleScene;
	}

	/**
	 * Initialize the window
	 * @param width The width of the window
	 * @param height The height of the window
	 * @return the Scene that was initialized
	 */
	private Scene init(int width, int height) {
		myRoot = new Group();
		myScene = new Scene(myRoot,width,height,Color.AZURE);
//        myScene.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
		return myScene;
	}

}
