package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIManager {
	private static final String TITLE = "SLogo";

	protected Stage myStage;
	private Scene myScene;
	private Group myRoot;
	
	private int myWindowWidth, myWindowHeight;

	public GUIManager(Stage stage){
		myStage = stage;
		Scene scene = init((int)stage.getWidth(), (int)stage.getHeight());
		stage.setScene(scene);
		stage.setTitle(TITLE);
		
		ConsoleUI console = new ConsoleUI();
		myRoot.getChildren().add(console);
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
